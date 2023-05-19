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
class Hangar {
    private int maxElements;
    private ArrayList<Weapon> weapons;
    private ArrayList <ShieldBooster> shieldBoosters;
    
    Hangar(int capacity){
        maxElements = capacity;
        weapons = new ArrayList<>();
        shieldBoosters = new ArrayList<>();
    }
    
    Hangar( Hangar h){
        maxElements = h.maxElements;
        weapons= h.weapons;
        shieldBoosters = h.shieldBoosters;
    }
    
    HangarToUI getUIversion(){
        return new HangarToUI(this);
    }
    
    private boolean spaceAvailable(){
        return ((weapons.size()+shieldBoosters.size())<maxElements);
    } 
    
    public boolean addWeapon(Weapon w){
        boolean out = false;
        if(spaceAvailable()){
            weapons.add(w);
            out = true;
        }
        return out;
    } 
    
    public boolean addShieldBooster(ShieldBooster s){
        boolean out = false;
         if(spaceAvailable()){
            shieldBoosters.add(s);
            out = true;
        }
         return out;
    }
    
    public int getMaxElements(){
        return maxElements;
    }
    
     public ArrayList<ShieldBooster> getShieldBoosters(){
        return shieldBoosters;
    }
    
     public ArrayList<Weapon> getWeapons(){
         return weapons;
     }
     
     public ShieldBooster removeShieldBooster(int s){
         ShieldBooster out = null;
         if (s<shieldBoosters.size() && s>=0){
             out = shieldBoosters.get(s);
             shieldBoosters.remove(s);
         }
         return out;
     }
     
     public Weapon removeWeapon(int w) {
         Weapon out = null;
         if (w<weapons.size() && w>=0){
                 out = weapons.get(w);
                 weapons.remove(w);            
         }
         return out; 
     }
     
        @Override
        public String toString(){
            String out = "Max Elements: " + maxElements + ", Weapons: " + weapons.toString() + ", Shields: " + shieldBoosters.toString();
            return out;
        }
}