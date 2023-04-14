/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deepspace;

/**
 *
 * @author cristobalmer
 */
class Weapon {
    private String name;
    private WeaponType type;
    private int uses;
    
    Weapon(String _name,WeaponType _type,int _uses){
        name = _name;
        type = _type;
        uses = _uses;
    }
    
    Weapon(Weapon w){
        name = w.name;
        type = w.type;
        uses = w.uses;
    }
    
    public String getName(){
        return name;
    }
    
    public WeaponType getType(){
        return type;
    }
    
    public int getUses(){
        return uses;
    }
    
    public float power(){
        return type.getPower();
    }
    
    public float useIt(){
        if (uses >0){
            uses--;
            return power();
        }else return 1.0f;
    }
    
    WeaponToUI getUIVersion(){
       return new WeaponToUI(this);
    }
    
    @Override
    public String toString(){
        String result= new String("Name of Weapon: ");
        result+=name+"\nType: "+type.toString()+"\nNumber of uses: "+String.valueOf(uses);
        return result;
    }    
}
