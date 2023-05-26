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
        super(station.getName(), new SuppliesPackage(station.getAmmoPower(), station.getFuelUnits(), station.getShieldPower()));       
              
        int nMedals = station.getNMedals();
        ArrayList<Weapon> weapons = station.getWeapons();
        ArrayList<ShieldBooster> shieldBoosters = station.getShieldBoosters();
        Hangar hangar = station.getHangar();
        Damage pendingDamage = station.getPendingDamage() ;
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
       if(transformation == SPACECITY)
           transformation = NOTRANSFORMATION;
       return transformation;
   
    }
    
    public PowerEfficientSpaceStationToUI getUIversion(){
        return new PowerEfficientSpaceStationToUI(this);
    }
    
}
