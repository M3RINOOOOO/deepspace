#encoding:utf-8

require_relative 'GameUniverseToUI'
require_relative 'GameStateController'
require_relative 'Dice'
require_relative 'Loot'
require_relative 'CombatResult'
require_relative 'GameCharacter'
require_relative 'ShotResult'
require_relative 'SpaceStation'
require_relative 'CardDealer'
require_relative 'EnemyStarShip'


module Deepspace
    class GameUniverse
        @@WIN = 10
        @@not_used = -1
        def initialize()
            @gameState = GameStateController.new()
            @turns = 0
            @dice = Dice.new()
            @currentStation= nil
			@currentEnemy= nil
			@currentStationIndex= @@not_used
            @spaceStations = Array.new()
        end 

        def combatGo(station,enemy)
            ch=@dice.firstShot()
            if(ch==GameCharacter::ENEMYSTARSHIP)
                fire = enemy.fire()
                result=station.receiveShot(fire)
                if (result==ShotResult::RESIST)
                    fire = station.fire()
                    result = enemy.receiveShot(fire)
                    enemyWins=(result==ShotResult::RESIST)
                else
                    enemyWins=true
                end
            else    
                fire = station.fire
                result = enemy.receiveShot(fire)
                enemyWins=(result==ShotResult::RESIST)
            end
A
            if(enemyWins)
                s = station.speed
                moves = @dice.spaceStationMoves(s)
                if(!moves)
                    damage = enemy.damage
                    station.cleanUpMountedItems
                    station.setPendingDamage(damage)
                    combatResult=CombatResult::ENEMYWINS
                else
                    station.move()
                    combatResult=CombatResult::STATIONESCAPES
                end
            else
                aLoot = enemy.loot
                station.setLoot(aLoot)
                combatResult=CombatResult::STATIONWINS
            end

            @gameState.next(@turns,@spaceStations.count)
            return combatResult
        end
        
        def combat() 
            state = @gameState.state()
            if ((state== GameState::BEFORECOMBAT)||(state()==GameState::INIT))
                result=combatGo(@currentStation,@currentEnemy)
            else 
                result = CombatResult::NOCOMBAT
            end 
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
        
        def state() 
            @gameState.state
        end

        def getUIversion()
            GameUniverseToUI.new(@currentStation, @currentEnemy)
        end

        def haveAWinner()
            @currentStation.nMedals >= @@WIN
        end
        
        def init(names) 
            state = @gameState.state
            if(state==GameState::CANNOTPLAY)
                @spaceStations = Array.new()
                dealer = CardDealer.instance
                names.each do |name|
                    supplies = dealer.nextSuppliesPackage()
                    station = SpaceStation.new(name,supplies)
                    @spaceStations.push(station)
                    nh = @dice.initWithNHangars()
                    nw = @dice.initWithNWeapons()
                    ns = @dice.initWithNShields()
                    lo = Loot.new(0,nw,ns,nh,0)
                    station.setLoot(lo)
                end
                @currentStationIndex = @dice.whoStarts(names.count)
                @currentStation = @spaceStations.at(@currentStationIndex)
                @currentEnemy = dealer.nextEnemy()
                @gameState.next(@turns,@spaceStations.count)
            end 
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
            out = false
            state = @gameState.state
            if(state == GameState::AFTERCOMBAT)
                stationState = @currentStation.validState()
                if(stationState)
                    @currentStationIndex = (@currentStationIndex+1)% (@spaceStations.count)
                    @turns += 1
                    @currentStation = @spaceStations[@currentStationIndex]
                    @currentStation.cleanUpMountedItems()
                    dealer = CardDealer.instance
                    @currentEnemy = dealer.nextEnemy()
                    @gameState.next(@turns,@spaceStations.count)
                    result = true
                end
            end 
            return result
        end 

        def to_s()
            getUIversion().to_s
        end
    end 
end 