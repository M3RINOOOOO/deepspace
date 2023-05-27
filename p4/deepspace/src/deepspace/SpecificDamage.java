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
public class SpecificDamage extends Damage{
    
    ArrayList<WeaponType> weapons;
    static private final int NOUSE = -1;
    
    public SpecificDamage(ArrayList<WeaponType> _weapons, int _nShields){
        super(_nShields);
        if (_weapons != null)
            weapons = new ArrayList<>(_weapons);
        else
            weapons = new ArrayList<>();
    }
    
    public SpecificDamage(SpecificDamage other){
        this(other.weapons, other.getNShields());
    }
    
    @Override
    public SpecificDamage copy(){
        return new SpecificDamage(this);
    }
    
    public ArrayList<WeaponType> getWeapons(){
        if (weapons != null)
            return new ArrayList<>(weapons);
        else
            return new ArrayList<>();
    }
    
    @Override
    public boolean hasNoEffect(){
        if (weapons != null)
            return weapons.isEmpty() && getNShields() == 0;
        else
            return getNShields() == 0;
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
    
    @Override
    public SpecificDamage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s){
        int shields = Integer.min(s.size(), getNShields());
        ArrayList<Weapon> wAux = new ArrayList<>(w);
        ArrayList<WeaponType> toSet = new ArrayList<>();
       
        for(WeaponType element: weapons) {
            int index = arrayContainsType(wAux, element);
          
            if(index != -1){  
              toSet.add(element); 
              wAux.remove(index);
            }
        }
        
        return new SpecificDamage(toSet, shields);
    }    
    
    @Override
    public void discardWeapon(Weapon w){
        if (!weapons.isEmpty()){
                weapons.remove(w.getType());
        }
    }
    
    @Override
    public String toString(){
        return  "Damage(" +
                "weapons = " + weapons +
                ", nShields = " + getNShields() +
                ")";
    }
    
    @Override
    public SpecificDamageToUI getUIversion(){
        return new SpecificDamageToUI(this);
    }
}
