#encoding:utf-8
require_relative "EnemyToUI.rb"
require_relative "ShotResult.rb"

module Deepspace
    class EnemyStarShip
        def initialize(n,a,s,l,d)
            @name = n
            @ammoPower = a 
            @shieldPower = s 
            @loot = l
            @damage = d
        end 

        def self.newCopy(e)
            EnemyStarShip.new(e.name,e.ammoPower,e.shieldPower,e.loot,e.damage)
        end 

        attr_reader :name, :ammoPower, :shieldPower, :loot, :damage

        def getUIversion()
            EnemyToUI.new(self)
        end 

        def fire()
            @ammoPower
        end 

        def protection()
            @shieldPower
        end 

        def receiveShot(shot)
            if protection() < shot
                ShotResult::DONOTRESIST
            else 
                ShotResult::RESIST
            end 
        end 

        def to_s()
            getUIversion().to_s
        end
    end 
end 
