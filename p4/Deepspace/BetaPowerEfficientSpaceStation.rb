#encoding:utf-8
require_relative "PowerEfficientSpaceStation.rb"
require_relative "BetaPowerEfficientSpaceStationToUI.rb"
require_relative "Dice.rb"
module Deepspace
    class BetaPowerEfficientSpaceStation < PowerEfficientSpaceStation
        @@EXTRAEFFICIENCY = 1.2 
        def initialize(station)
            super(station)
            @dice = Dice.new()
        end
        def fire()
            if dice.extraEfficiency()
                super*@@EXTRAEFFICIENCY
            else 
                super
            end 
        end
        def getUIversion()
			Deepspace::BetaPowerEfficientSpaceStationToUI.new(self)
		end 
        def to_s
            "(Beta)"+super
        end 
    end
    #station = SpaceStation.new("p",SuppliesPackage.new(1,2,3))
    #puts station.fire()
    #puts station.protection()
    #bpes = BetaPowerEfficientSpaceStation.new(station)
    #puts bpes.fire()
    #puts bpes.protection()
end