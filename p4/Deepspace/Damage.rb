#encoding:utf-8
require_relative "WeaponType.rb"
require_relative "DamageToUI.rb"
require_relative "Weapon.rb"

module Deepspace
    class Damage
	private_class_method :new
	def initialize(s)
		@nShields=s            
	end 
	
       
        def copy()
            return this.clone
            
        end    

        attr_reader:nShields

        def getUIversion()
			Deepspace::DamageToUI.new(self)
        end 
             
        def discardShieldBooster()
            if (@nShields-1 >= 0)
                @nShields=@nShields-1
            end 
        end    

        def to_s()
            getUIversion().to_s
        end
        #a = Damage.newNumericWeapons(5,5)
        #new_a = a.adjust([WeaponType::LASER,WeaponType::MISSILE,WeaponType::PLASMA],1)
        #puts new_a
        #b = Damage.newNumericWeapons(2,3)
        #new_b = b.adjust([WeaponType::LASER,WeaponType::MISSILE,WeaponType::PLASMA],4)
        #puts new_b
        #c = Damage.newSpecificWeapons([WeaponType::LASER,WeaponType::MISSILE,WeaponType::PLASMA],4)
        #new_c = c.adjust([WeaponType::MISSILE],1)
        #puts new_c
        #d = Damage.newSpecificWeapons([WeaponType::LASER,WeaponType::MISSILE],1)
        #new_d = d.adjust([WeaponType::LASER,WeaponType::MISSILE,WeaponType::PLASMA,WeaponType::PLASMA],4)
        #puts new_d
    end 
end
