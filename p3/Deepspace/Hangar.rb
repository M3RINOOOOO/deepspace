require_relative "HangarToUI.rb"

module Deepspace
	class Hangar
		def initialize(_maxElements)
			@maxElements=_maxElements
            @shieldBoosters = Array.new()  
            @weapons = Array.new()
		end
				
		def self.newCopy(h)
			out = Hangar.new(h.maxElements)
            h.shieldBoosters().each {|x| out.addShieldBooster(x)}
            h.weapons().each {|x| out.addWeapon(x)}
            return out
		end
		
		attr_reader:maxElements, :weapons, :shieldBoosters
		
		def getUIversion()
			HangarToUI.new(self)
		end
		
		def spaceAvailable()
			return @maxElements > (@weapons.count+@shieldBooster.count)
		end
		
		def addWeapon(w)
			if spaceAvailable()
				@weapons >> w
				return true
			else
				return false
			end
		end
		
		def addShieldBooster(w)
			if spaceAvailable()
				@shieldBooster >> w
				return true
			else
				return false
			end
		end
		
		def removeShieldBooster(s)
			return shieldBooster.delete_at(s)
		end
		
		def removeWeapon(w)
			return weapons.delete_at(w)
		end
		
		def to_s()
			getUIversion().to_s
		end
		
	end
end	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
