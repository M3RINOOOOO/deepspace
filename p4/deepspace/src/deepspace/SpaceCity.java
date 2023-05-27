/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deepspace;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author cristobalmer
 */
public class SpaceCity extends SpaceStation{
    
    private SpaceStation base;
    private ArrayList<SpaceStation> collaborators;
    
    public SpaceCity(SpaceStation base, ArrayList<SpaceStation> rest){
        super(base);
        this.base = base;
        collaborators = new ArrayList<>(rest);
    }
    
    public ArrayList<SpaceStation> getCollaborators(){
        return collaborators;
    }
    
    @Override
    public float fire(){
        float factor = base.fire();
        for(int i=0;i<collaborators.size();i++){
            factor += collaborators.get(i).fire();
        }
        return factor;
    }
    
    @Override
    public float protection(){
        float factor = base.protection();
        for(int i=0;i<collaborators.size();i++){
            factor += collaborators.get(i).protection();
        }
        return factor;
    }
    
    @Override
    public Transformation setLoot(Loot loot){
        super.setLoot(loot);
        return Transformation.NOTRANSFORM;
    }
    
    @Override
    public SpaceCityToUI getUIversion() {
        return new SpaceCityToUI(this);
    }
}
