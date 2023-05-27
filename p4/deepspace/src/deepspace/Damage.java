/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deepspace;


import java.util.ArrayList;
import java.util.Arrays;


/**
 *
 * @author Sergio
 */
abstract class Damage {
    
    private int nShields;
    
    Damage(int s){
        nShields = s;
    }
    
    public abstract Damage copy();
    
    public int getNShields(){
        return nShields;
    }
    
    public abstract boolean hasNoEffect();
    
    public abstract Damage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s);
    
    public abstract void discardWeapon(Weapon w);
    
    public void discardShieldBooster(){
        if (nShields > 0)
            nShields--;
    }
    
    public abstract String toString();
    
    abstract public DamageToUI getUIversion();
}
