require_relative 'SpaceCityToUI'
require_relative 'SpaceStation'

module Deepspace
    class SpaceCity < SpaceStation
        
        def initialize(base, rest)
            super(base.name(),SuppliesPackage.new(base.ammoPower(),base.fuelUnits(),base.shieldPower()))
            @collaborators = rest
            @base = base
            @nMedals = base.nMedals
				
	    @hangar = base.hangar
            @pendingDamage = base.pendingDamage
	    @shieldBoosters = base.shieldBoosters 
	    @weapons = base.weapons 
        end
        attr_reader :collaborators
        
        def fire()
        	potencia = super
        	@collaborators.each do |station|
        		potencia += station.fire()
        	end
        	
        	return potencia
        end
        
        def protection()
        	potencia = super
        	@collaborators.each do |station|
        		potencia += station.protection()
        	end
        	
        	return potencia
        end
        
        def setLoot(loot)
        	super(loot)
        	return Transformation::NOTRANSFORM
        end
        
        def getUIversion()
		Deepspace::SpaceCityToUI.new(self)
	end
    end
    #station = SpaceStation.new("p",SuppliesPackage.new(1,2,1))
    #hangar = Hangar.new(3)
    #hangar.addWeapon(Weapon.new("Láser infinito",WeaponType::LASER,100))
    #station.receiveHangar(hangar)
    #station.mountWeapon(0)
    #puts station.fire()
    #puts station.protection()
    #station2 = SpaceStation.new("p2",SuppliesPackage.new(2,2,2))
    #puts station2.fire()
    #puts station2.protection()
    #station3 = SpaceStation.new("p3",SuppliesPackage.new(3,2,3))
    #puts station3.fire()
    #puts station3.protection()
    #rest = [station2,station3]
    #puts rest
    #pwsp = SpaceCity.new(station,rest)
    #puts pwsp.fire()
    #puts pwsp.protection()
end
