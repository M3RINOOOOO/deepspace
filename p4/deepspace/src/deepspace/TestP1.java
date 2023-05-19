/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package deepspace;


/**
 *
 * @author Sergio
 */
public class TestP1 {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Loot loot1 = new Loot(2,1,0,1,1);
        SuppliesPackage SuppliesPackage1 = new SuppliesPackage(1.0f, 3.0f, 2.0f);
        SuppliesPackage SuppliesPackage2 = new SuppliesPackage(SuppliesPackage1);
        ShieldBooster ShieldBooster1 = new ShieldBooster("shieldboost", 1.0f, 2);
        ShieldBooster ShieldBooster2 = new ShieldBooster(ShieldBooster1);
        Weapon Weapon1 = new Weapon("weapon", WeaponType.LASER, 3);
        Weapon Weapon2 = new Weapon(Weapon1);
        
        System.out.println("loot1 tiene " + loot1.getNSupplies()+ " supplies");
        System.out.println("loot1 tiene " + loot1.getNWeapons()+ " weapons");
        System.out.println("loot1 tiene " + loot1.getNShields()+ " shields");
        System.out.println("loot1 tiene " + loot1.getNHangars()+ " hangares");
        System.out.println("loot1 tiene " + loot1.getNMedals()+ " medals\n");
        
        System.out.println("SuppliesPackage1 tiene " + SuppliesPackage1.getAmmoPower()+ " ammo power");
        System.out.println("SuppliesPackage1 tiene " + SuppliesPackage1.getFuelUnits()+ " fuel units");
        System.out.println("SuppliesPackage1 tiene " + SuppliesPackage1.getShieldPower()+ " shield power\n");
        
        System.out.println("SuppliesPackage2 tiene " + SuppliesPackage2.getAmmoPower()+ " ammo power");
        System.out.println("SuppliesPackage2 tiene " + SuppliesPackage2.getFuelUnits()+ " fuel units");
        System.out.println("SuppliesPackage2 tiene " + SuppliesPackage2.getShieldPower()+ " shield power\n");
        
        System.out.println("ShieldBooster1 tiene " + ShieldBooster1.getBoost() + " boost");
        System.out.println("ShieldBooster1 tiene " + ShieldBooster1.getUses() + " usos\n");
        
        System.out.println("ShieldBooster2 tiene " + ShieldBooster2.getBoost() + " boost");
        System.out.println("ShieldBooster2 tiene " + ShieldBooster2.getUses() + " usos\n");
        
        System.out.println("Weapon1 es de tipo: " + Weapon1.getType());
        System.out.println("Weapon1 tiene: " + Weapon1.getUses() + " usos\n");
        
        System.out.println("Weapon2 es de tipo: " + Weapon2.getType());
        System.out.println("Weapon2 tiene: " + Weapon2.getUses() + " usos\n");
        
       
        Dice dice = new Dice();
        
        int init0Hangars = 0;
        int init1Hangar = 0;
        int init1Weapon = 0;
        int init2Weapon = 0;
        int init3Weapon = 0;
        int init0Shields = 0;
        int init1Shields = 0;
        int startsPlayer1 = 0;
        int startsPlayer2= 0;
        int enemyShotsFirst = 0;
        int spaceStationShotsFirst = 0;
        for(int i=0;i<100;++i){
            if(dice.initWithNHangars() == 0)
                ++init0Hangars;
            else
                ++init1Hangar;
            
            int aux = dice.initWithNWeapons();
            if(aux == 1)
                ++init1Weapon;
            else if(aux == 2)
                ++init2Weapon;
            else
                ++init3Weapon;
            
            if(dice.initWithNShields() == 0)
                ++init0Shields;
            else
                ++init1Shields;
                
            if(dice.firstShot() == GameCharacter.ENEMYSTARSHIP)
                ++enemyShotsFirst;
            else
                ++spaceStationShotsFirst;
            
            if(dice.whoStarts(2)== 0)
                ++startsPlayer1;
            else
                ++startsPlayer2;
        }
        
        System.out.println("Se han iniciado " + init0Hangars + " estaciones con 0 hangares");
        System.out.println("Se han iniciado " + init1Hangar + " estaciones con 1 hangar\n");
        
        System.out.println("Se han iniciado " + init1Weapon + " estaciones con 1 arma");
        System.out.println("Se han iniciado " + init2Weapon + " estaciones con 2 armas");
        System.out.println("Se han iniciado " + init3Weapon + " estaciones con 3 armas\n");
        
        System.out.println("Se han iniciado " + init0Shields + " estaciones con 0 escudos");
        System.out.println("Se han iniciado " + init1Shields + " estaciones con 1 escudo\n");
        
        System.out.println("Ha disparado primero el enemigo " + enemyShotsFirst + " veces\n");
        System.out.println("Ha disparado primero la estacion " + spaceStationShotsFirst + " veces\n");
        
        System.out.println("Ha empezado primero el jugador 1 " + startsPlayer1 + " veces\n");
        System.out.println("Ha empezado primero el jugador 2 " + startsPlayer2 + " veces\n");

              
        
        
    }
    
}