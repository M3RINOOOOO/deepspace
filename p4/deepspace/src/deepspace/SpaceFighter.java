/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deepspace;

/**
 *
 * @author cristobalmer
 */
public interface SpaceFighter {
    float fire();
    float protection();
    ShotResult receiveShot(float shot);
}