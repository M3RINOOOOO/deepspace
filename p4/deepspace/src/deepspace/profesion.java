/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package deepspace;

/**
 *
 * @author Sergio
 */
public enum profesion {
    
    MEDICO(1,100.000f),
    CELADOR(3,15.000f),
    ENFERMERO(2,25.000f);
    
    private final int nivel;
    private final float sueldo;
    
    profesion(int nivel, float sueldo){
        this.nivel = nivel;
        this.sueldo = sueldo;
    }
    
    float getSueldo(){
        return this.sueldo;
    }
    
    int getNivel(){
        return this.nivel;
    }
    
    
}
