/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deepspace;

import java.util.ArrayList;

/**
 *
 * @author Sergio
 */
class PowerEfficientSpaceStation extends SpaceStation{
    
    private static final float EFFICIENCYFACTOR = 1.10f;
    
    PowerEfficientSpaceStation(SpaceStation station){             
        super(station);       
    }
    
    @Override
    public float fire(){
        return super.fire()*EFFICIENCYFACTOR;
    }
    
    @Override
    public float protection(){
        return super.protection()*EFFICIENCYFACTOR;
    }
    @Override
    public Transformation setLoot(Loot loot){
       Transformation transformation = super.setLoot(loot);
       if(transformation == Transformation.SPACECITY)
           transformation = Transformation.NOTRANSFORM;
       return transformation;
   
    }
    
    public PowerEfficientSpaceStationToUI getUIversion(){
        return new PowerEfficientSpaceStationToUI(this);
    }
    
}
