#encoding:utf-8
require_relative "WeaponType"
require_relative "WeaponToUI"
module Deepspace
    class Weapon
        def initialize(_name,_type,_uses)
            @name = _name
            @type = _type
            @uses = _uses
        end 
        def self.newCopy(w)
            Weapon.new(w.name,w.type,w.uses)
        end     

        attr_reader:name,:type,:uses

        def power()
            @type.power()
        end 
        def useIt()
            if (@uses>0)
                @uses = @uses - 1
                return power()
            else 
                return 1.0
            end     
        end 

        def to_s()
            return "Name: #{@name}, Type: #{@type}, Power: #{power()}, Uses: #{@uses}"
        end 

        def getUIversion()
			Deepspace::WeaponToUI.new(self)
		end      
    end 
    #a = Weapon.new("arma",WeaponType::LASER,2)
    #puts a
end 