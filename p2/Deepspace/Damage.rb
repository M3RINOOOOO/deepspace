require_relative "WeaponType.rb"
require_relative "DamageToUI.rb"
require_relative "Weapon.rb"

module Deepspace
    class Damage
		@@not_used=-1
		def initialize(w,wl,s)
			@nWeapons=w
			@weapons=wl
			@nShields=s            
		end 

        def self.newNumericWeapons(w,s)
            new(w,nil,s)
        end 

        def self.newSpecificWeapons(wl,s)
            new(@@not_used,wl,s)
        end 

        def self.newCopy(d)
            if d.weapons = nil
                Damage.newNumericWeapons(d.nWeapons,d.nShields)
            else
                Damage.newSpecificWeapons(d.weapons,d.nShields)
            end 
        end    

        attr_reader:nShields, :nWeapons, :weapons

        def getUIversion()
			Deepspace::DamageToUI.new(self)
        end 

        def arrayContainsType(w,t)
            out = @@not_used
            i = 0
            w.each do |weapon|
                if weapon.type = t 
                    out = i
                    break
                end 
                i+=1
            end
            return out
        end 

        def adjust(w,s)
            if s.count > @nShields
                new_nShields = @nShields
            else
                new_nShields = s.count
            end

            if @weapons == nil
                if w.count > @nWeapons
                    new_nWeapons = @nWeapons
                else
                    new_nWeapons = w.count
                end     
                return Damage.newNumericWeapons(new_nWeapons,new_nShields)
            else
                result=[]
				w_aux=w.clone
				@weapons.each do |x| 	
					i=arrayContainsType(w_aux,x);
					if i!=@@not_used
						result << x
						w_aux.delete_at(i)
					end
				end
				return Damage.newSpecificWeapons(result, n_shields)
            end 
        end 

        def discardWeapon(w)
            if @weapons != nil
                indice = arrayContainsType(@weapons,w.type)
                if indice != -1
                    w.remove(indice)
                end 
            elsif @nWeapons-1 >= 0 
                @nWeapons = @nWeapons-1
            end 
        end 

        def discardShieldBooster()
            if (@nShields-1 >= 0)
                @nShields=@nShields-1
            end 
        end    

        def hasNoEffect()
            if @weapons != nil
				return @weapons.empty? && @nShields == 0
            else
				return @nShields + @nWeapons == 0
            end
        end

        def to_s()
            getUIversion().to_s
        end

    end 
end