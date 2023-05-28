require_relative 'Damage'
require_relative 'SpecificDamageToUI'


module Deepspace
	class SpecificDamage < Damage
		@@not_used = -1;
		public_class_method :new
		
		def initialize(wl,s)
			super(s)
			@weapons = wl
		end
		
		attr_reader:weapons
		
		def arrayContainsType(w,t)
			i = 0
			w.each do |weapon_aux|
		   	     if weapon_aux.type == t
		   	     	return i
		   	     else
		   	     	i += 1
		   	     end
		   	end
		    # No se encontró elemento
		    return -1
		end 
		
		def adjust(wl,s)
			if (s.count > @nShields)
			        new_nShields = @nShields
			else
				new_nShields = s.count
			end

			result=[]
			w_aux=wl.clone
		    	@weapons.each do |x| 	
				i=arrayContainsType(w_aux,x);
				if i!=@@not_used
					result << x
					w_aux.delete_at(i)
				end
		    	end
		    	SpecificDamage.new(result,new_nShields)
		    
		end 
		
		def discardWeapon(w)
	    
		      	indice = @weapons.index(w.type)
		        if indice != -1
		            @weapons.delete_at(indice)
		        end 
		    
		end 
		
		
		def hasNoEffect()
			return @weapons.empty? && @nShields == 0
		end
		
		def getUIversion()
			Deepspace::SpecificDamageToUI.new(self)
		end 
	end
end
