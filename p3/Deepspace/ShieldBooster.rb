#encoding:utf-8
require_relative "ShieldToUI.rb"
module Deepspace
    class ShieldBooster
        def initialize(_name,_boost,_uses)
            @name = _name
            @boost = _boost
            @uses = _uses
        end 
        
        def self.newCopy(s)
            ShieldBooster.new(s.name,s.boost,s.uses)
        end 

        def name()
            @name
        end

        def boost()
            @boost
        end
        
        def uses()
            @uses
        end
        
        def useIt()
            if (@uses > 0)
                @uses = @uses - 1
                @boost
            else 
                return 1.0
            end
        end 
        
        def to_s()
            return "Boost: #{@boost}, Uses: #{@uses}"
        end

        def getUIversion()
			Deepspace::ShieldToUI.new(self)
		end        
    end 
    #a = ShieldBooster.new("prueba",1,2)
    #puts a.to_s
end 