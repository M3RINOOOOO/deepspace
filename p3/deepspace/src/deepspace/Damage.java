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
public class Damage {
    
    private int nShields;
    private int nWeapons;
    private ArrayList<WeaponType> weapons;
    static private final int NOUSE = -1;
    
    Damage(int w, int s){
        nShields = s;
        nWeapons = w;
        weapons = null;
    }
    
    Damage(ArrayList<WeaponType> wl, int s){
        nShields = s;
        nWeapons = NOUSE;
        weapons = wl;                                    
    }
    
    Damage(Damage d){
       nShields = d.nShields;
       nWeapons = d.nWeapons;
       ArrayList<WeaponType> aux = new ArrayList<WeaponType>();
       if(d.weapons != null)
           aux = d.weapons;
       weapons = aux;           
    }
    
    DamageToUI getUIversion(){
         return new DamageToUI(this);
    }
    
    private int arrayContainsType(ArrayList<Weapon> w, WeaponType t){
        int result = NOUSE;
        int i = 0;
        while(i<w.size() && result == NOUSE){
            if(w.get(i).getType() == t)
                result = i;
            else
                i++;
        }
        return result;
    }
    
    public Damage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s){
        
        Damage d = new Damage(this);
        
        
        if(d.nShields > s.size())
            d.nShields = s.size();
        
        
        if(d.nWeapons == NOUSE){
            ArrayList<Weapon> wAux = new ArrayList<Weapon>(w);
            ArrayList<WeaponType> result = new ArrayList<WeaponType>();
            
            for(int i=0; i<d.weapons.size(); i++){
                int aux = arrayContainsType(wAux,d.weapons.get(i));        
                if(aux != -1 ){
                    result.add(d.weapons.get(i));
                    wAux.remove(aux);
                }
            }
       
            d.weapons = result;           
        }          
        else
            if(d.nWeapons > w.size())
                d.nWeapons = w.size();
          
        
                
        
        return d;
    }
    
    public void discardWeapon(Weapon w){
         if(nWeapons == NOUSE){
             weapons.remove(w.getType());
         }else
             nWeapons--;             
    }
    
    public void discardShieldBooster(){
        if(nShields > 0){
            nShields--;
        }
    }
    
    public boolean hasNoEffect(){
         boolean noeffect = true;
            if(nShields != 0)
                noeffect = false;
            if(noeffect && nWeapons == -1)
                noeffect = weapons.isEmpty();
            else
                if(nWeapons != 0)
                    noeffect = false;
            
            return noeffect;
                
    }
    
    public int getNShields(){
         return nShields; 
    }
    
    public int getNWeapons(){
         return nWeapons; 
    }
    
    public ArrayList<WeaponType> getWeapons(){
           return weapons;
    }
    
    @Override
    public String toString(){
        String out;
        if(nWeapons == NOUSE)
            out = "Num Shields: " + nShields + ", Weapons: " + weapons.toString();
        else
            out = "Num Shields: " + nShields + ",Num Weapons: " + nWeapons;
        return out;
    }
}
