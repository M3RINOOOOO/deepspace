/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deepspace;

/**
 *
 * @author cristobalmer
 */
class SuppliesPackage {
    private float ammoPower;
    private float fuelUnits;
    private float shieldPower;
    
    SuppliesPackage(float _ammoPower,float _fuelUnits,float _shieldPower){
        ammoPower = _ammoPower;
        fuelUnits = _fuelUnits;
        shieldPower = _shieldPower;
    }
    SuppliesPackage(SuppliesPackage s){
        ammoPower = s.ammoPower;
        fuelUnits = s.fuelUnits;
        shieldPower = s.shieldPower;
    }
    public float getAmmoPower(){
        return ammoPower;
    }    
    public float getFuelUnits(){
        return fuelUnits;
    }    
    public float getShieldPower(){
        return shieldPower;
    }    
    
    @Override
    public String toString(){
        String result= new String("Suppliespackage with ammoPower: ");
        result+=String.valueOf(ammoPower)+"\nfuelUnits: "+String.valueOf(fuelUnits)+"\nshieldPower: "+String.valueOf(shieldPower);
        return result;
    }
}
