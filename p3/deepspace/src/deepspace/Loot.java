/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deepspace;

/**
 *
 * @author cristobalmer
 */
class Loot {
    private int nSupplies;
    private int nWeapons;
    private int nShields;
    private int nHangars;
    private int nMedals;
    
    Loot(int _nSupplies,int _nWeapons,int _nShields,int _nHangars,int _nMedals){
        nSupplies = _nSupplies;
        nWeapons = _nWeapons;
        nShields = _nShields;
        nHangars = _nHangars;
        nMedals = _nMedals;
    }
    public int getNSupplies(){
        return nSupplies;
    }
    public int getNWeapons(){
        return nWeapons;
    }
    public int getNShields(){
        return nShields;
    }
    public int getNHangars(){
        return nHangars;
    }
    public int getNMedals(){
        return nMedals;
    }
    
    LootToUI getUIVersion(){
       return new LootToUI(this);
    }
    
    @Override
    public String toString(){
        String result= new String("Number of supplies: ");
        result+=String.valueOf(nSupplies)+"\nNumber of weapons: "+String.valueOf(nWeapons)+"\nNumber of shields: "
            +String.valueOf(nShields)+"\nNumber of hangars: "+String.valueOf(nHangars)+"\nNumber of medals: "+String.valueOf(nMedals);
        return result;
    }
}
