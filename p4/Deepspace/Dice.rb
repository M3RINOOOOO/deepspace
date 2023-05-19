#encoding:utf-8
require_relative "GameCharacter.rb"
module Deepspace
    class Dice
        def initialize()
            @NHANGARSPROB = 0.25
            @NSHIELDSPROB = 0.25
            @NWEAPONSPROB = 0.33
            @FIRSTSHOTPROB= 0.5
            @generator = Random.new()
        end     
        
        def initWithNHangars()
            prob = @generator.rand
            if prob < @NHANGARSPROB
                0 
            else 
                1
            end 
        end 

        def initWithNWeapons()
            prob = @generator.rand
            if prob < @NWEAPONSPROB
                1 
            elsif prob < @NWEAPONSPROB*2
                2
            else 
                3
            end 
        end 

        def initWithNShields()
            prob = @generator.rand
            if prob < @NSHIELDSPROB
                0 
            else 
                1
            end 
        end 

        #PARA CREAR UN NUMERO ALEATORIO ENTRE 0 Y nPlayers-1
        def whoStarts(nPlayers)
            @generator.rand(0..nPlayers-1)
        end 

        def firstShot()
            prob = @generator.rand
            if prob < @FIRSTSHOTPROB
                GameCharacter::SPACESTATION
            else 
                GameCharacter::ENEMYSTARSHIP
            end 
        end 

        def spaceStationMoves(speed)
            prob = @generator.rand
            prob < speed
        end 
    end 
    #dado = Dice.new()
    #puts dado.initWithNHangars()
    #puts dado.initWithNWeapons()
    #puts dado.initWithNShields()
    #puts dado.whoStarts(4)
    #puts dado.firstShot()
    #puts dado.spaceStationMoves(0.5)
end