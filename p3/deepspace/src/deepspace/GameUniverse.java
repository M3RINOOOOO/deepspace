/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deepspace;


import java.util.ArrayList;

/**
 *
 * @author Sergio
 */
public class GameUniverse {
    private static final int WIN = 10;
    private int currentStationIndex;
    private int turns;
    private GameStateController gameState;
    private EnemyStarShip currentEnemy;
    private ArrayList<SpaceStation> spaceStations;
    private SpaceStation currentStation;
    private Dice dice;
    
    private boolean GameStatus(){
        return gameState.getState() == GameState.INIT || gameState.getState() == GameState.AFTERCOMBAT;
    }
    
    public GameUniverse(){
        gameState = new GameStateController();
        turns = 0;
        dice = new Dice();
        spaceStations = new ArrayList<SpaceStation>();
    }
    
    CombatResult combat(SpaceStation station, EnemyStarShip enemy){
        CombatResult combatResult;
        boolean enemyWins;
        float fire;
        ShotResult result;
        GameCharacter ch = dice.firstShot();
        if(ch == GameCharacter.ENEMYSTARSHIP){
            fire = enemy.fire();
            result = station.receiveShot(fire);
            if(result == ShotResult.RESIST){
                fire = station.fire();
                result = enemy.receiveShot(fire);
                enemyWins = (result == ShotResult.RESIST);
            }
            else{
                enemyWins = true;
            }
        }
        else{
            fire = station.fire();
            result = enemy.receiveShot(fire);
            enemyWins = (result == ShotResult.RESIST);
        }
        
        
        if(enemyWins){
            float s = station.getSpeed();
            boolean moves = dice.spaceStationMoves(s);
            if(!moves){
                Damage damage = enemy.getDamage();
                station.setPendingDamage(damage);
                combatResult = CombatResult.ENEMYWINS;
            }
            else{
                station.move();
                combatResult = CombatResult.STATIONESCAPES;
            }
        }
        else{
            Loot aloot = enemy.getLoot();
            station.setLoot(aloot);
            combatResult = CombatResult.STATIONWINS;
        }
        gameState.next(turns, spaceStations.size());
        
        return combatResult;
    }
    
    public CombatResult combat(){
        GameState state = getState();
        CombatResult result;
        if((state == GameState.BEFORECOMBAT) || (state == GameState.INIT))
            result = combat(currentStation,currentEnemy);
        else
            result = CombatResult.NOCOMBAT;
        return result;
    }
    
    public void discardHangar(){
        if(GameStatus()){
            currentStation.discardHangar();
        }
    }
    
    public void discardShieldBooster(int i){
        if(GameStatus()){
            currentStation.discardShieldBooster(i);
        }
    }
    
    public void discardShieldBoosterInHangar(int i){
        if(GameStatus()){
            currentStation.discardShieldBoosterInHangar(i);
        }
    }
    
    public void discardWeapon(int i){
        if(GameStatus()){
            currentStation.discardWeapon(i);
        }
    }
    
    public void discardWeaponInHangar(int i){
        if(GameStatus()){
            currentStation.discardWeaponInHangar(i);
        }
    }
    
    public GameState getState(){
        return gameState.getState();
    }
    
    public GameUniverseToUI getUIversion(){
        return new GameUniverseToUI(currentStation,currentEnemy);
    }
    
    public boolean haveAWinner(){
        return currentStation.getNMedals() >= WIN;
    }
    
    public void init(ArrayList<String> names){
        GameState state = getState();
        if(state != GameState.CANNOTPLAY){
            spaceStations = new ArrayList<SpaceStation>();
            CardDealer dealer = CardDealer.getInstance();
            
            for(int i=0; i<names.size();i++){
                SuppliesPackage supplies = dealer.nextSuppliesPackage();
                SpaceStation station = new SpaceStation(names.get(i),supplies);
                spaceStations.add(station);
                
                int nh = dice.initWithNHangars();
                int nw = dice.initWithNWeapons();
                int ns = dice.initWithNShields();
                
                Loot lo = new Loot(0,nw,ns,nh,0);
                station.setLoot(lo);
            }
            
            currentStationIndex = dice.whoStarts(names.size());
            currentStation = spaceStations.get(currentStationIndex);
            currentEnemy = dealer.nextEnemy();
            
            gameState.next(turns, spaceStations.size());
        }
    }
    
    public void mountShieldBooster(int i){
        if(GameStatus()){
            currentStation.mountShieldBooster(i);
        }
    }
    
    public void mountWeapon(int i){
        if(GameStatus()){
            currentStation.mountWeapon(i);
        }
    }
    
    public boolean nextTurn(){
        boolean result = false;
        GameState state = getState();
        if(state == GameState.AFTERCOMBAT){
            boolean stationState = currentStation.validState();
            if(stationState){
                currentStationIndex=(currentStationIndex+1)%spaceStations.size();
                turns++;
                currentStation = spaceStations.get(currentStationIndex);
                currentStation.cleanUpMountedItems();
                CardDealer dealer = CardDealer.getInstance();
                currentEnemy = dealer.nextEnemy();
                gameState.next(turns, spaceStations.size());
                result = true;
            }
        }
        
        return result;
    }
    
    
}
