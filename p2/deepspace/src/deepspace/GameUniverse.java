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
                throw new UnsupportedOperationException();  
    }
    
    public CombatResult combat(){
                throw new UnsupportedOperationException();  
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
    
    public GameUniverseToUI getUIVersion(){
        return new GameUniverseToUI(currentStation,currentEnemy);
    }
    
    public boolean haveAWinner(){
        return currentStation.getNMedals() >= WIN;
    }
    
    public void init(String[] names){
        
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
        throw new UnsupportedOperationException(); 
    }
    
    
}
