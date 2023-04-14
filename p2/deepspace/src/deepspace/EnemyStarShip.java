/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deepspace;


 
/**
 *
 * @author Sergio
 */
public class EnemyStarShip {
    private float ammoPower;
    private String name;
    private float shieldPower;
    private Loot loot;
    private Damage damage;
    
    
    EnemyStarShip(String n, float a, float s, Loot l, Damage d){
        name = n;
        ammoPower = a;
        shieldPower = s;
        loot = l;
        damage = d;
    }
    
    EnemyStarShip(EnemyStarShip e){
        name = e.name;
        ammoPower = e.ammoPower;
        shieldPower = e.shieldPower;
        loot = e.loot;
        damage = e.damage;
    }
    
    EnemyToUI getUIversion(){
        return new EnemyToUI(this);
    }
    
    public float fire(){
        return ammoPower; 
    }
    
    public float getAmmoPower(){
        return ammoPower;
    }
    
    public Damage getDamage(){
        return damage;
    }
    
    public Loot getLoot(){
        return loot;  
    }
    
    public String getName(){
        return name;
    }
    
    public float getShieldPower(){
        return shieldPower;
    }
    
    public float protection(){
        return shieldPower; 
    }
    
    public ShotResult receiveShot(float shot){
        ShotResult result = ShotResult.RESIST;
        if(shieldPower < shot)
            result = ShotResult.DONOTRESIST;
        
        return result;
    }
    
    @Override
    public String toString(){
        String out = "Name: " + name + ", Ammo power: " + ammoPower + ", shield power: " 
                     + shieldPower + ", loot: " + loot.toString() + ", damage: " + damage.toString();
        return out;     
    }
}
