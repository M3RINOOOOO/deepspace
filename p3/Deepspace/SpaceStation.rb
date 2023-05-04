require_relative "ShotResult.rb"
require_relative "CardDealer.rb"


module Deepspace
	class SpaceStation
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
		
		def assignFuelValue(f)
			if(f<MAXFUEL)
				@fuelUnits = f
			else
				@fuelUnits = MAXFUEL
			end
		end
		
		def cleanPendingDamage()
			if(@pendindDamage.hasNoEffect())
				@pendingDamage = nil
			end
		end
		
		def self.newSpaceStation(n,supplies)
			new(supplies.ammoPower,supplies.fuelUnits,n,0,supplies.shieldPower,nil,nil,nil,nil)
		end
		
		attr_reader:ammoPower,:fuelUnits,:hangar,:name,:nMedals,:pendingDamage,:shieldBooster,:shieldPower,:weapons
		
		def cleanUpMountedItems()
			@weapons.delete_if {|w| w.uses == 0}
			@shieldBooster.delete_if {|s| s.uses == 0}
		end
		
		def discardHangar()
			@hangar = nil
		end
		
		def discardShieldBooster(i)
			size = @shieldBooster.size()
			if(i >= 0 && i < size)
				s = shieldBooster.remove(i)
				if(@pendingDamage != null)
					discardShield(s)
					cleanPendindDamage()
				end
			end
			
		end
		
		def discardShieldBoosterInHangar(i)
			if(@hangar != nil)
				hangar.removeShieldBooster(i)
			end
		end
		
		def discardWeapon(i)
			size = @weapons.size()
			if(i >= 0 && i < size)
				w = weapons.remove(i)
				if(@pendingDamage != null)
					discardWeapon(w)
					cleanPendindDamage()
				end
			end
		end
		
		def discardWeaponInHangar(i)
			if(@hangar != nil)
				hangar.removeWeapon(i)
			end
		end
		
		def fire()
			size = @weapons.size()
			factor = 1
			for i in(0..size)
 				w = weapons.next()
 				factor *= w.useIt()
			end
			return @ammoPower * factor
		end
		
		def getSpeed()
			return @fuelUnits/MAXFUEL
		end
		
		def getUIversion()
			SpaceStationToUI.new(self)
		end
		
		def mountShieldBooster(i)
			if(@hangar != nil)
				aux = ShieldBooster(@hangar.removeShieldBooster(i))
				if(aux != nil)
					@shieldBooster << aux
				end
			end
		end
		
		def mountWeapon(i)
			if(@hangar != nil)
				aux = Weapon(@hangar.removeWeapon(i))
				if(aux != nil)
					@weapons << aux
				end
			end
		end
		
		def move()
			if(@fuelUnits*getSpeed() <= @fuelUnits)
				@fuelUnits -= @fuelUnits*getSpeed()
			end
		end
		
		def protection()
			size = @shieldBooster.size()
			factor = 1
			for i in(0..size)
				s = shieldBoosters.next()
				factor *= s.useIt()
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
			myProtection = protection()
			if(myProtection >= shot)
				@shieldPower -= @@SHIELDLOSTPERUNITSHOT*shot
				@shieldPower = [0.0,@shielPower].max()
				return ShotResult::RESIST
			else
				@shieldPower = 0.0
				return ShotResult::DONOTRESIST
			end
			
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
			dealer = CardDealer.instance
			h = loot.nHangars()
			if(h>0)
				hangar = dealer.nextHangar()
				receiveHangar(hangar)
			end
			elements = loot.nSupplies()
			for i in(1..elements)
				sup = dealer.nextSuppliesPackage()
				receiveSupplies(sup)
			end
			elements = loot.nWeapons()
			for i in(1..elements)
				weap = dealer.nextWeapon()
				receiveWeapon(weap)
			end
			elements = loot.nShields()
			for i in(1..elements)
				sh = dealer.nextShieldBooster()
				receiveShieldBooster(sh)
			end
			medals = loot.nMedals()
			@nMedals += medals	
			
		end
		
		def setPendingDamage(d)
			@pendindDamage = d.adjust(weapons,shieldBooster)
		end
		
		def validState()
			return (@pendindDamage == nil || @pendingDamage.hasNoEffect())
		end
		
	end
	
	
	
end			
