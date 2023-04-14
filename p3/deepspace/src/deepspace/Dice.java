/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deepspace;
import java.util.Random;

/**
 *
 * @author cristobalmer
 */
class Dice {
     private final float NHANGARSPROB;
     private final float NSHIELDSPROB;
     private final float NWEAPONSPROB;
     private final float FIRSTSHOTPROB;
     private Random generator;
     
     Dice(){
        generator = new Random();
        NHANGARSPROB = 0.25f;
        NSHIELDSPROB = 0.25f;
        NWEAPONSPROB = 0.33f;
        FIRSTSHOTPROB = 0.5f;
     }
     int initWithNHangars(){
         return (generator.nextFloat()<NHANGARSPROB ? 0 : 1);
     }
     
     int initWithNWeapons(){
         float prob = generator.nextFloat();
         int result;
         if (prob < NWEAPONSPROB){
             result = 1;
         }
         else if (prob< NWEAPONSPROB*2){
             result = 2;
         }
         else{
             result = 3;
         }
         return result;
     }
     
     int initWithNShields(){
         return (generator.nextFloat()<NSHIELDSPROB ? 0 : 1);
     }
     
     int whoStarts(int nPlayers){
         return (generator.nextInt(nPlayers));
     }
     
     GameCharacter firstShot(){
         return (generator.nextFloat()<FIRSTSHOTPROB ? GameCharacter.SPACESTATION : GameCharacter.ENEMYSTARSHIP);
     }
     
     boolean spaceStationMoves(float speed){
         return generator.nextFloat()<speed;
     }
}
