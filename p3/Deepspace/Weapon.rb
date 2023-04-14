#encoding:utf-8
require_relative "WeaponType.rb"
require_relative "WeaponToUI.rb"
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
        def name()
            @name
        end
        def type()
            @type
        end 
        def uses()
            @uses
        end
        def power()
            @type.power()
        end 
        def useIt()
            if (uses>0)
                uses = uses - 1
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