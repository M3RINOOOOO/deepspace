/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deepspace;

/**
 *
 * @author Sergio
 */
class SuppliesPackage {
    private final float ammoPower;
    private final float fuelUnits;
    private final float shieldPower;
    
    SuppliesPackage(float ammoPower, float fuelUnits, float shieldPower){
        this.ammoPower = ammoPower;
        this.fuelUnits = fuelUnits;
        this.shieldPower = shieldPower;
    }
    
    SuppliesPackage(SuppliesPackage s){
        this.ammoPower = s.ammoPower;
        this.fuelUnits = s.fuelUnits;
        this.shieldPower = s.shieldPower;
    }
    
    float getAmmoPower(){
        return this.ammoPower;
    }
    
    float getFuelUnits(){
       return this.fuelUnits;
    }
   
    float getShieldPower(){
        return this.shieldPower;
    }
  
}
