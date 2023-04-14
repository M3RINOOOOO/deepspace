require_relative "HangarToUI.rb"

module Deepspace
	class Hangar
		def initialize(m,w,s)
			@maxElements = m
			@weapons = w
			@shieldBooster = s
		end
		
		def self.Hangar(capacity)
			new(m,nil,nil)
		end
		
		def self.newCopy(h)
			Hangar.new(h.maxElements,h.weapons,h.shieldBooster)
		end
		
		attr_reader:maxElements, :weapons, :shieldBooster
		
		def getUIversion()
			HangarToUI.new(self)
		end
		
		def spaceAvailable()
			return @maxElements > (@weapons.length()+@shieldBooster.length())
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
