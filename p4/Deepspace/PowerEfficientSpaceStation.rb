#encoding:utf-8
require_relative "PowerEfficientSpaceStationToUI.rb"
require_relative "SpaceStation.rb"
require_relative "SuppliesPackage.rb" #ABORRAR
module Deepspace
    class PowerEfficientSpaceStation < SpaceStation
        @@EFFICIENCYFACTOR = 1.1
        def initialize(station)
            super(station.name(),SuppliesPackage.new(station.ammoPower(),station.fuelUnits(),station.shieldPower()))
            @nMedals = station.nMedals
				
	    @hangar = station.hangar
            @pendingDamage = station.pendingDamage
	    @shieldBoosters = station.shieldBoosters 
	    @weapons = station.weapons 
        end
        def fire()
            super*@@EFFICIENCYFACTOR
        end
        def protection()
            super*@@EFFICIENCYFACTOR
        end
        def setLoot(loot)
            trans = super(loot);
            if (trans == Transformation::SPACECITY)
                return Transformation::NOTRANSFORM;
            else
                return trans;
            end 
        end
        def getUIversion()
			Deepspace::PowerEfficientSpaceStationToUI.new(self)
	end
    end
    #station = SpaceStation.new("p",SuppliesPackage.new(1,2,3))
    #puts station.fire()
    #puts station.protection()
    #pwsp = PowerEfficientSpaceStation.new(station)
    #puts pwsp.fire()
    #puts pwsp.protection()
end
