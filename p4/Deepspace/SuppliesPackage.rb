#encoding:utf-8
module Deepspace
    class SuppliesPackage
        def initialize(_ammoPower,_fuelUnits,_shieldPower)
            @ammoPower = _ammoPower
            @fuelUnits = _fuelUnits
            @shieldPower = _shieldPower
        end 
        def ammoPower()
            @ammoPower
        end 
        def fuelUnits()
            @fuelUnits
        end
        def shieldPower()
            @shieldPower
        end 
        #CONSTRUCTOR DE COPIA
        def self.newCopy(s)
            SuppliesPackage.new(s.ammoPower,s.fuelUnits,s.shieldPower)
        end         
        def to_s()
            return "ammoPower: #{@ammoPower}, fuelUnits: #{@fuelUnits}, shieldPower #{@shieldPower}"
        end
    end 
    #a = SuppliesPackage.new(1,2,3)
    #puts a
end 