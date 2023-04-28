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
    
    Loot(int Supplies, int Weapons, int Shields, int Hangars, int Medals){
        nSupplies = Supplies;
        nWeapons = Weapons;
        nShields = Shields;
        nHangars = Hangars;
        nMedals = Medals;
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
    
    LootToUI getUIversion(){
        return new LootToUI(this);
    }
}
