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
public class BetaPowerEfficientSpaceStation extends PowerEfficientSpaceStation{
    
    private Dice dice;
    private static final float EXTRAEFFICIENCY = 1.20f;
    
    BetaPowerEfficientSpaceStation(SpaceStation station){                     
        super(station);  
        dice = new Dice();
    }
    
    @Override
    public float fire(){
        if(dice.extraEfficiency()){           
            return 0;
        }
        else{
            return super.fire();
        }
    }
    
    public BetaPowerEfficientSpaceStationToUI getUIversion(){
        return new BetaPowerEfficientSpaceStationToUI(this);
    }
}
