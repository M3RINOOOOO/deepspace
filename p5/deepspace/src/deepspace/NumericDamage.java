/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deepspace;

import java.util.ArrayList;
/**
 *
 * @author cristobalmer
 */
public class NumericDamage extends Damage{
    
    private int nWeapons;
    
    public NumericDamage(int _nWeapons, int _nShields) {
        super(_nShields);
        nWeapons = _nWeapons;
    }
    
    public NumericDamage(NumericDamage other){
        this(other.nWeapons, other.getNShields());
    }
    
    @Override
    public NumericDamage copy(){
        return new NumericDamage(nWeapons, getNShields());
    }
    
    public int getNWeapons(){
        return nWeapons;
    }
    
    @Override
    public boolean hasNoEffect(){
        return getNShields() + nWeapons == 0;
    }
    
    @Override
    public NumericDamage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s){
        int shields = Integer.min(s.size(), getNShields());
        return new NumericDamage(Integer.min(nWeapons, w.size()), shields);
    }
    
    @Override
    public void discardWeapon(Weapon w){
        if (nWeapons > 0)
            nWeapons--;
    }
    
    @Override
    public String toString() {
        String message = "[NumericDamage] -> "
                + "Number of shields: " + getNShields()
                + ", Number of weapons: " + nWeapons;
        return message;
    }
    
    @Override
    public NumericDamageToUI getUIversion() {
        return new NumericDamageToUI(this);
    }
}
