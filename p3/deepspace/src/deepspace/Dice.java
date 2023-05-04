/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deepspace;
import java.util.Random;
/**
 *
 * @author Sergio
 */
public class Dice {
    private final float NHANGARSPROB;
    private final float NSHIELDSPROB;
    private final float NWEAPONSPROB;
    private final float FIRSTSHOTPROB;
    private Random generator;
    
    Dice(){
        this.NHANGARSPROB=0.25f;
        this.NSHIELDSPROB=0.25f;
        this.NWEAPONSPROB=0.33f;
        this.FIRSTSHOTPROB=0.5f;
        this.generator = new Random();
    }
    
    int initWithNHangars(){
        int ret = 1;
        if(generator.nextFloat()<NHANGARSPROB)
            ret = 0;
        
        return ret;
    }
    
    int initWithNWeapons(){
        int ret;
        float prob=generator.nextFloat();
        if(prob<NWEAPONSPROB)
            ret = 1;
        else if(prob < 2*NWEAPONSPROB)
            ret = 2;
        else
            ret = 3;
        return ret;
    }
    
    int initWithNShields(){
        int ret = 1;
        if(generator.nextFloat()<NSHIELDSPROB)
            ret = 0;
        return ret;
    }
    
    int whoStarts(int nPlayers){
        return generator.nextInt(nPlayers);
    }
    
    GameCharacter firstShot(){
        GameCharacter ret = GameCharacter.ENEMYSTARSHIP;
        if(generator.nextFloat()<FIRSTSHOTPROB)
            ret = GameCharacter.SPACESTATION;
        return ret;
    }
    
    boolean spaceStationMoves(float speed){
        boolean ret = false;
        if(generator.nextFloat()<speed)
            ret = true;
        return ret;
    }
    
    

}
