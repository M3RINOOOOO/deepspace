require_relative 'Damage'
require_relative 'NumericDamageToUI'

module Deepspace
	class NumericDamage < Damage
	
		public_class_method :new
		
		def initialize(w,s)
			super(s)
			@nWeapons = w
		end
		
		attr_reader:nWeapons
		
		def adjust(w,s)
		    if (s.count > @nShields)
		        new_nShields = @nShields
		    else
		        new_nShields = s.count
		    end
		    
		    if w.count > @nWeapons
		        new_nWeapons = @nWeapons
		    else
		        new_nWeapons = w.count
		    end     
		    NumericDamage.new(new_nWeapons,new_nShields)
		    
		end 
		
		
		def discardWeapon(w)        	
		    	if @nWeapons-1 >= 0 
		        	@nWeapons = @nWeapons-1
		    	end 
		end 
		
		
		def hasNoEffect()          
			return @nShields + @nWeapons == 0          
		end
		
		def getUIversion()
			Deepspace::NumericDamageToUI.new(self)
		end 
	
	end
end
