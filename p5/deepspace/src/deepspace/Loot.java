/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deepspace;

/**
 *
 * @author Sergio
 */
public class Loot {
    private final int nSupplies;
    private final int nWeapons;
    private final int nShields;
    private final int nHangars;
    private final int nMedals;
    private boolean getEfficient;
    private boolean spaceCity;
    
    Loot(int Supplies, int Weapons, int Shields, int Hangars, int Medals){
        nSupplies = Supplies;
        nWeapons = Weapons;
        nShields = Shields;
        nHangars = Hangars;
        nMedals = Medals;
        getEfficient = false;
        spaceCity = false;
    }
    
    Loot(int Supplies, int Weapons, int Shields, int Hangars, int Medals, boolean ef, boolean city){
        nSupplies = Supplies;
        nWeapons = Weapons;
        nShields = Shields;
        nHangars = Hangars;
        nMedals = Medals;
        getEfficient = ef;
        spaceCity = city;
    }    
    
    int getNSupplies(){
        return nSupplies;
    }
    
    int getNWeapons(){
        return nWeapons;   
    }
    
    int getNShields(){
        return nShields;
    }
    
    int getNHangars(){
        return nHangars;
    }
    
    int getNMedals(){
        return nMedals;
    }
    
    boolean getEfficient(){
        return getEfficient;
    }
    
    boolean spaceCity(){
        return spaceCity;
    }
    
    LootToUI getUIversion(){
        return new LootToUI(this);
    }
}
