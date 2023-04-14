/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deepspace;
import java.util.ArrayList;

/**
 *
 * @author cristobalmer
 */
class SpaceStation {
    private static final float MAXFUEL = 100f;
    private static final float SHIELDLOSSPERUNITSHOT = 0.1f;
    
    private float ammoPower;
    private float fuelUnits;
    private String name;
    private int nMedals;
    private float shieldPower;
    
    private ArrayList<Weapon> weapons;
    private ArrayList<ShieldBooster> shieldBoosters;
    private Hangar hangar;
    private Damage pendingDamage;
    
    private void assignFuelValue(float f){
        if (f<MAXFUEL){
            fuelUnits = f;
        } else fuelUnits = MAXFUEL;
    }
    
    private void cleanPendingDamage(){
        if (pendingDamage.hasNoEffect()){
            pendingDamage = null;
        }
    }
    
    SpaceStation(String n,SuppliesPackage supplies){
        weapons = new ArrayList<>();
        shieldBoosters = new ArrayList<>();
        name = n;
        receiveSupplies(supplies);
    }
    
    public void cleanUpMountedItems(){
       weapons.removeIf(w->(w.getUses() == 0));
       shieldBoosters.removeIf(s->(s.getUses() == 0));
    }
    
    public void discardHangar(){
        hangar = null;
    }
    
    public void discardShieldBooster(int i){
        
    }
    
    public void discardShieldBoosterInHangar(int i){
        if (hangar != null){
            hangar.removeShieldBooster(i);
        }
    }
    
    public void discardWeapon(int i){
    
    }
    
    public void discardWeaponInHangar(int i){
        if (hangar != null){
            hangar.removeWeapon(i);
        }
    }
    
    public float fire(){
        
    }
    
    public float getAmmoPower(){
        return ammoPower;
    }
    
    public float getFuelUnits(){
        return fuelUnits;
    }
    
    public Hangar getHangar(){
        return hangar;
    }
    
    public String getName(){
        return name;
    }
    
    public int getNMedals(){
        return nMedals;
    }
    
    public Damage getPendingDamage(){
        return pendingDamage;
    }
    
    public ArrayList<ShieldBooster> getShieldBoosters(){
        return shieldBoosters;
    }
    
    public float getShieldPower(){
        return shieldPower;
    }
    
    public float getSpeed(){
        return fuelUnits/MAXFUEL;
    }
    
    public SpaceStationToUI getUIversion(){
        return new SpaceStationToUI(this);
    }
    
    public ArrayList<Weapon> getWeapons(){
        return weapons;
    }
    
    public void mountShieldBooster(int i){
        if (hangar != null){
            ShieldBooster aux = hangar.removeShieldBooster(i);
            if (aux != null){
                shieldBoosters.add(aux);
            }
        }
    }
    
    public void mountWeapon(int i){
        if (hangar != null){
            Weapon aux = hangar.removeWeapon(i);
            if (aux != null){
                weapons.add(aux);
            }
        }
    }
    
    public void move(){
        if (fuelUnits - fuelUnits*getSpeed()>=0){
            fuelUnits -= fuelUnits*getSpeed();
        }
    }
    
    public float protection(){
        
    }
            
    public void receiveHangar(Hangar h){
        if (hangar ==null){
            hangar = h;
        }
    }
    
    public boolean receiveShieldBooster(ShieldBooster s){
        boolean out = false;
        if (hangar!=null){
            out = hangar.addShieldBooster(s);
        }
         return out;        
    }
    
    public ShotResult receiveShot(float shot){
    
    }
    
    public void receiveSupplies(SuppliesPackage s){
        ammoPower += s.getAmmoPower();
        assignFuelValue(fuelUnits+s.getFuelUnits());
        shieldPower += s.getShieldPower();
    }
    
    public boolean receiveWeapon(Weapon w){
        boolean out = false;
        if (hangar!=null){
            out = hangar.addWeapon(w);
        } 
         return out;
    }
    
    public void setLoot(Loot loot){
        
    }
    
    public void setPendingDamage(Damage d){
        d.adjust(weapons, shieldBoosters);
    }
    
    public boolean validState(){
        return (pendingDamage == null || pendingDamage.hasNoEffect());
    }
}
