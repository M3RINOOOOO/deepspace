/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package deepspace;

/**
 *
 * @author cristobalmer
 */
public enum WeaponType {
    
    LASER(2f), MISSILE(3f), PLASMA(4f); 
    //atributo instancia privado
    private final float power;
    //visibilidad de paquete
    WeaponType(float _power) { 
        power = _power;
    }
     //visibilidad de paquete
    float getPower(){
        return power;
    }
   
}
