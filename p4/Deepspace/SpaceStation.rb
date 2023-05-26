#encoding:utf-8
require_relative "ShotResult"
require_relative "CardDealer"
require_relative 'SpaceStationToUI'

module Deepspace
	class SpaceStation
		@@not_used = -1
		def initialize(n, supplies)
			@MAXFUEL = 100 
			@SHIELDLOSSPERUNITSHOT = 0.1     
			@name=n
			@nMedals = 0
				
			@hangar = nil
			@pendingDamage = nil
			@shieldBoosters = []  
			@weapons = [] 
			@ammoPower= supplies.ammoPower
			@shieldPower= supplies.shieldPower
			@fuelUnits = supplies.fuelUnits
						
		end

		def self.newCopy(station)
			@MAXFUEL = 100
			@SHIELDLOSSPERUNITSHOT = 0.1
			@name = station.name
			@nMedals = station.nMedals
			@hangar = station.hangar
			@pendingDamage = station.pendingDamage
			@shieldBoosters = station.shieldBoosters
			@weapons = station.weapons
			@ammoPower= station.ammoPower
			@shieldPower= station.shieldPower
			@fuelUnits = station.fuelUnits
		end
		
		def assignFuelValue(f)
			if(f<@MAXFUEL)
				@fuelUnits = f
			else
				@fuelUnits = @MAXFUEL
			end
		end
		
		def cleanPendingDamage()
			if(@pendingDamage.hasNoEffect())
				@pendingDamage = nil
			end
		end
		
		
		attr_reader:ammoPower,:fuelUnits,:hangar,:name,:nMedals,:pendingDamage,:shieldBoosters,:shieldPower,:weapons
		
		def cleanUpMountedItems()
			@weapons.delete_if {|w| w.uses == 0}
			@shieldBoosters.delete_if {|s| s.uses == 0}
		end
		
		def discardHangar()
			@hangar = nil
		end
		
		def discardShieldBooster(i)
			size = @shieldBoosters.count
			if(i >= 0 && i < size)
				s = @shieldBoosters.delete_at(i)
				if(@pendingDamage != nil)
					discardShield(s)
					cleanPendingDamage()
				end
			end
			
		end
		
		def discardShieldBoosterInHangar(i)
			if(@hangar != nil)
				@hangar.removeShieldBooster(i)
			end
		end
		
		def discardWeapon(i)
			size = @weapons.size()
			if(i >= 0 && i < size)
				w = @weapons.delete_at(i)
				if(@pendingDamage != nil)
					discardWeapon(w)
					cleanPendingDamage()
				end
			end
		end
		
		def discardWeaponInHangar(i)
			if(@hangar != nil)
				@hangar.removeWeapon(i)
			end
		end
		
		def fire()
			factor=1
        
            for w in @weapons do
                factor*=w.useIt()
            end
            
            return @ammoPower*factor
		end
		
		def speed()
			return @fuelUnits/@MAXFUEL
		end
		
		def getUIversion()
			SpaceStationToUI.new(self)
		end
		
		def mountShieldBooster(i)
			if (@hangar != nil && i!=@@not_used)
                aux = @hangar.removeShieldBooster(i)
                if (aux != nil)
                    @shieldBoosters.push(aux)
                end 
            end 
		end
		
		def mountWeapon(i)
			if (@hangar != nil && i!=@@not_used)
                aux = @hangar.removeWeapon(i)
                if (aux != nil)
                    @weapons.push(aux)
                end 
            end 
		end
		
		def move()
			if (@fuelUnits -  speed() >= 0)
                @fuelUnits -=  speed()
            else 
                @fuelUnits = 0
            end
		end
		
		def protection()
			factor=1
        
            for s in @shieldBoosters do
                factor*=s.useIt()
            end
            
            return @shieldPower*factor
		end
		
		def receiveHangar(h)
			if(@hangar == nil)
				@hangar = h
			end
		end
		
		def receiveShieldBooster(s)
			if(@hangar == nil)
				return false
			else
				return @hangar.addShieldBooster(s)
			end
		end
		
		def receiveShot(shot)
			myProtection= protection()
            if(myProtection>=shot)
                remaining=@SHIELDLOSSPERUNITSHOT*shot
                if (@shieldPower-remaining>=0)
                    @shieldPower = @shieldPower-remaining
                else 
                    @shieldPower = 0
                end                
                result= ShotResult::RESIST
            else
                result= ShotResult::DONOTRESIST
            end
            return result
		end
		
		def receiveSupplies(s)
			@fuelUnits += s.fuelUnits
			@ammoPower += s.ammoPower
			@shieldPower += s.shieldPower
		end
		
		def receiveWeapon(w)
			if(@hangar == nil)
				return false
			else
				return @hangar.addWeapon(w)
			end
		end
		
		def setLoot(loot)
			dealer = CardDealer.instance()
            h = loot.nHangars()
            
            if (h>0)
                hangar=dealer.nextHangar()
                receiveHangar(hangar)
            end
            
            elements= loot.nSupplies()

            elements.times do 
                sup= dealer.nextSuppliesPackage()
                receiveSupplies(sup)
            end
            
            elements= loot.nWeapons()
            
            elements.times do 
                weap=dealer.nextWeapon()
                receiveWeapon(weap)
            end
            
            elements= loot.nShields()
            
            elements.times do 
                sh= dealer.nextShieldBooster()
                receiveShieldBooster(sh)
            end
            
            medals=loot.nMedals()
            @nMedals+=medals
		end
		
		def setPendingDamage(d)
			@pendingDamage = d.adjust(@weapons,@shieldBoosters)
		end
		
		def validState()
			return (@pendingDamage == nil || @pendingDamage.hasNoEffect())
		end
		
		def to_s()
            getUIversion().to_s
        end 
	
	
	end
end			
