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
class SpaceStation implements SpaceFighter{
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
        nMedals = 0;
        weapons = new ArrayList<>();
        shieldBoosters = new ArrayList<>();
        name = n;
        receiveSupplies(supplies);
        hangar = null;
        pendingDamage = null;
        
    }
    
    SpaceStation(SpaceStation station){
        ammoPower = station.ammoPower;
        fuelUnits = station.fuelUnits;
        name = station.name;
        nMedals = station.nMedals;
        shieldPower = station.shieldPower;

        if ( station.pendingDamage != null )
            pendingDamage = station.pendingDamage.copy();
        if ( station.weapons != null )
            weapons = new ArrayList<>(station.weapons);
        if ( station.shieldBoosters != null )
            shieldBoosters = new ArrayList<>(station.shieldBoosters);
        if ( station.hangar != null )
            hangar = new Hangar(station.hangar);  
    }
    
    
    public void cleanUpMountedItems(){
       weapons.removeIf(w->(w.getUses() == 0));
       shieldBoosters.removeIf(s->(s.getUses() == 0));
    }
    
    public void discardHangar(){
        hangar = null;
    }
    
    public void discardShieldBooster(int i){
        int size = shieldBoosters.size();
        if(i>=0 && i<size){
            ShieldBooster s = shieldBoosters.remove(i);
            if(pendingDamage != null){
                pendingDamage.discardShieldBooster();
                cleanPendingDamage();
            }        
        }
    }
    
    public void discardShieldBoosterInHangar(int i){
        if (hangar != null){
            hangar.removeShieldBooster(i);
        }
    }
    
    public void discardWeapon(int i){
        int size = weapons.size();
        if(i>=0 && i<size){
            Weapon w =weapons.remove(i);
            if(pendingDamage != null){
                pendingDamage.discardWeapon(w);
                cleanPendingDamage();
            }        
        }
    }
    
    public void discardWeaponInHangar(int i){
        if (hangar != null){
            hangar.removeWeapon(i);
        }
    }
    
    @Override
    public float fire(){
        int size = weapons.size();
        float factor = 1;
        Weapon w;
        for (int i =0;i<size;i++){
            w = weapons.get(i);
            factor *= w.useIt();
        }
        return ammoPower*factor;
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
        if (hangar != null && i!=-1){
            ShieldBooster aux = hangar.removeShieldBooster(i);
            if (aux != null){
                shieldBoosters.add(aux);
            }
        }
    }
    
    public void mountWeapon(int i){
        if (hangar != null && i!=-1){
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
    
    @Override
    public float protection(){
        int size = shieldBoosters.size();
        float factor = 1;
        ShieldBooster s;
        for (int i =0;i<size;i++){
            s = shieldBoosters.get(i);
            factor *= s.useIt();
        }
        return shieldPower*factor;
    }
            
    public void receiveHangar(Hangar h){
        if (hangar == null){
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
    
    @Override
    public ShotResult receiveShot(float shot){
        ShotResult out;
        float myProtection = protection();
        if(myProtection>=shot){
            shieldPower-=SHIELDLOSSPERUNITSHOT *shot;
            if (shieldPower < 0.0f){
                shieldPower = 0.0f;
            }
            out = ShotResult.RESIST;
        }else{
            shieldPower=0.0f;
            out = ShotResult.DONOTRESIST;
        }
        return out;
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
    
    public Transformation setLoot(Loot loot){
        CardDealer dealer = CardDealer.getInstance();
        int h = loot.getNHangars();
        if(h>0){
            Hangar hangar = dealer.nextHangar();
            receiveHangar(hangar);
        }
        
        int elements = loot.getNSupplies();
        for(int i =0;i<elements;i++){
            SuppliesPackage sup = dealer.nextSuppliesPackage();
            receiveSupplies(sup);
        }
        
        elements = loot.getNWeapons();
         for(int i =0;i<elements;i++){
            Weapon weap = dealer.nextWeapon();
            receiveWeapon(weap);
        }
         
         elements = loot.getNShields();
         for(int i =0;i<elements;i++){
            ShieldBooster sh =dealer.nextShieldBooster();
            receiveShieldBooster(sh);
        }
        
         int medals = loot.getNMedals();
         nMedals+=medals;
         
         if(loot.getEfficient()){
            return Transformation.GETEFFICIENT;
        }else if(loot.spaceCity()){
            return Transformation.SPACECITY;
        }else{
            return Transformation.NOTRANSFORM;
        }
    }
    
    public void setPendingDamage(Damage d){
        pendingDamage = d.adjust(weapons, shieldBoosters);
    }
    
    public boolean validState(){
        return (pendingDamage == null || pendingDamage.hasNoEffect());
    }
    
    
}