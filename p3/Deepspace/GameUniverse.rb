require_relative "GameStateController.rb"
require_relative "GameState.rb"
require_relative "Dice.rb"
require_relative "EnemyStarShip.rb"
require_relative "GameUniverseToUI.rb"

module Deepspace
    class GameUniverse
        @@WIN = 10
        def initialize()
            @gameState = GameStateController.new()
            @turns = 0
            @dice = Dice.new()
            @currentStation= nil
			@currentEnemy= nil
			@currentStationIndex= nil
        end 

        def combatGo(station,enemy)

        end
        
        def combat() 

        end

        def discardHangar()
            if @gameState.state == GameState::INIT || @gameState.state == GameState::AFTERCOMBAT
                @currentStation.discardHangar()
            end
        end

        def discardShieldBooster(i) 
            if @gameState.state == GameState::INIT || @gameState.state == GameState::AFTERCOMBAT
                @currentStation.discardShieldBooster(i)
            end
        end

        def discardShieldBoosterInHangar(i) 
            if @gameState.state == GameState::INIT || @gameState.state == GameState::AFTERCOMBAT
                @currentStation.discardShieldBoosterInHangar(i)
            end
        end

        def discardWeapon(i) 
            if @gameState.state == GameState::INIT || @gameState.state == GameState::AFTERCOMBAT
                @currentStation.discardWeapon(i)
            end
        end

        def discardWeaponInHangar(i) 
            if @gameState.state == GameState::INIT || @gameState.state == GameState::AFTERCOMBAT
                @currentStation.discardWeaponInHangar(i)
            end
        end
        
        def getState() 
            @gameState.state
        end

        def getUIversion()
            GameUniverseToUI.new(self)
        end

        def haveAWinner()
            @currentStation.nMedals >= @@WIN
        end
        
        def init(names) 

        end 
         
        def mountShieldBooster(i) 
            if @gameState.state == GameState::INIT || @gameState.state == GameState::AFTERCOMBAT
                @currentStation.mountShieldBooster(i)
            end     
        end 

        def mountWeapon(i) 
            if @gameState.state == GameState::INIT || @gameState.state == GameState::AFTERCOMBAT
                @currentStation.mountWeapon(i) 
            end     
        end 

        def nextTurn() 

        end 

        def to_s()
            getUIversion().to_s
        end
    end 
end 