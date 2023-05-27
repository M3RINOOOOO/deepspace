#encoding:utf-8
require_relative "LootToUI"
module Deepspace
    class Loot
        def initialize(_nSupplies,_nWeapons,_nShields,_nHangars,_nMedals,efficient=false,spaceCity=false)
            @nSupplies = _nSupplies
            @nWeapons = _nWeapons
            @nShields = _nShields
            @nHangars = _nHangars
            @nMedals = _nMedals
            @efficient = efficient
            @spaceCity = spaceCity
        end
        
      
        attr_reader:nSupplies,:nWeapons,:nShields,:nHangars,:nMedals,:efficient,:spaceCity


        def to_s()
            return "Supplies: #{@nSupplies}, Weapons: #{@nWeapons}, Shields: #{@nShields}, Hangars: #{@nHangars}, Medals: #{@nMedals}, Efficient: #{@efficient}, Space City: #{@spaceCity}"
        end 
        def getUIversion()
			Deepspace::LootToUI.new(self)
		end

    end
    #a = Loot.new(1,2,3,4,5)
    #puts a.to_s
end
