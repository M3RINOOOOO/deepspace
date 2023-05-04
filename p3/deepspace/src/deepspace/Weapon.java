/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deepspace;

/**
 *
 * @author Sergio
 */
public class Weapon {
    
    private String name;
    private WeaponType type;
    private int uses;
    
    Weapon(String name, WeaponType type, int uses){
        this.name = name;
        this.type = type;
        this.uses = uses;
        
    }
    
    Weapon(Weapon s){
        this.name = s.name;
        this.type = s.type;
        this.uses = s.uses;
    }
    
    WeaponToUI getUIversion(){
        return new WeaponToUI(this);
    }
    
    WeaponType getType(){
        return this.type;      
    }
    
    int getUses(){
        return this.uses;
    }
    
    float power(){
        return this.type.getPower();
    }
    
    float useIt(){
        float ret;
        if(this.uses>0){
            --this.uses;
            ret = power();
        }else
            ret = 1.0f;
        return ret;        
    }
    
    @Override
    public String toString(){
        String out;
        out = "Name: " + name + ", Weapon Type: " + type + ", Uses: " + uses;
        return out;
    }
}
