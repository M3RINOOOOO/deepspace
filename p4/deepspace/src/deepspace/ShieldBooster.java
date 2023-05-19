/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deepspace;

/**
 *
 * @author Sergio
 */
public class ShieldBooster {
    
    private String name;
    private float boost;
    private int uses;
    
    ShieldBooster(String name, float boost, int uses){
        this.name = name;
        this.boost = boost;
        this.uses = uses;
    }
    
    ShieldBooster( ShieldBooster s){
        this.name = s.name;
        this.boost = s.boost;
        this.uses = s.uses;
    }
    
    float getBoost(){
        return this.boost;
    }
    
    int getUses(){
        return this.uses;
    }
    
    float useIt(){
        float ret;
        if(uses>0){
            --uses; 
            ret = boost;
        }
        else
            ret = 1.0f;
        
        return ret;
    }
    
    ShieldToUI getUIversion(){
        return new ShieldToUI(this);
    }
}
