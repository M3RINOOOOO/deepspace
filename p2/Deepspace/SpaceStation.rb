module Deepspace
	class SpaceStation
		@@MAXFUEL = 100
		@@SHIELDLOSTPERUNITSHOT = 0.1
		def initialize(a,f,n,m,sp,w,sb,p,h)
			@ammoPower = a
			@fuelUnits = f
			@name = n
			@nMedals = m
			@shieldPower = sp
			@weapons = w
			@shieldBooster = sb
			@pendingDamage = p
			@hangar = h
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
			
			
		end
		
		def discardShieldBoosterInHangar(i)
			if(@hangar != nil)
				hangar.removeShieldBooster(i)
			end
		end
		
		def discardWeapon(i)
		
		end
		
		def discardWeaponInHangar(i)
			if(@hangar != nil)
				hangar.removeWeapon(i)
			end
		end
		
		def fire()
		
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
		
		def receiveShot
		
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
		
		end
		
		def setPendingDamage(d)
			@pendindDamage = d.adjust(weapons,shieldBooster)
		end
		
		def validState()
			return (@pendindDamage == nil || @pendingDamage.hasNoEffect())
		end
		
	end
	
end			
