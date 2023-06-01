/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.GUI;

import controller.Controller;
import deepspace.EnemyToUI;
import deepspace.GameState;
/**
 *
 * @author crist
 */
public class EnemyStarShipView extends javax.swing.JPanel {
    private LootView lootView;
    private DamageView damageView;
    /**
     * Creates new form EnemyStarShipView
     */
    public EnemyStarShipView() {
        initComponents();
        
        lootView = new LootView();
        loot_enemigo.add(lootView);
        
        damageView = new DamageView();
        damage_enemigo.add(damageView);
    }
    
    void setEnemy(EnemyToUI e){
        nombre_enemigo.setText(e.getName());
        potencia_enemigo.setText(Float.toString(e.getAmmoPower()));
        defensa_enemigo.setText(Float.toString(e.getShieldPower()));
        
        lootView.setLoot(e.getLoot());
        damageView.setDamage(e.getDamage());
        
        if(Controller.getInstance().getState() == GameState.BEFORECOMBAT || Controller.getInstance().getState() == GameState.INIT){
            lootView.setVisible(false);
            damageView.setVisible(false);
        }
        else{
            lootView.setVisible(true);
            damageView.setVisible(true);
        }
        
        repaint();
        revalidate();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo_enemigo = new javax.swing.JLabel();
        titulo_potencia_fuego = new javax.swing.JLabel();
        titulo_potencia_defensa = new javax.swing.JLabel();
        nombre_enemigo = new javax.swing.JLabel();
        potencia_enemigo = new javax.swing.JLabel();
        defensa_enemigo = new javax.swing.JLabel();
        loot_enemigo = new javax.swing.JPanel();
        damage_enemigo = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        titulo_enemigo.setText("Enemigo :");

        titulo_potencia_fuego.setText("Potencia de fuego :");

        titulo_potencia_defensa.setText("Potencia de defensa :");

        nombre_enemigo.setText("jLabel4");

        potencia_enemigo.setText("jLabel1");

        defensa_enemigo.setText("jLabel2");

        loot_enemigo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        damage_enemigo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titulo_potencia_defensa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(defensa_enemigo))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titulo_enemigo)
                            .addComponent(titulo_potencia_fuego))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(potencia_enemigo)
                            .addComponent(nombre_enemigo)))
                    .addComponent(loot_enemigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(damage_enemigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titulo_enemigo)
                    .addComponent(nombre_enemigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titulo_potencia_fuego)
                    .addComponent(potencia_enemigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titulo_potencia_defensa)
                    .addComponent(defensa_enemigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loot_enemigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(damage_enemigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel damage_enemigo;
    private javax.swing.JLabel defensa_enemigo;
    private javax.swing.JPanel loot_enemigo;
    private javax.swing.JLabel nombre_enemigo;
    private javax.swing.JLabel potencia_enemigo;
    private javax.swing.JLabel titulo_enemigo;
    private javax.swing.JLabel titulo_potencia_defensa;
    private javax.swing.JLabel titulo_potencia_fuego;
    // End of variables declaration//GEN-END:variables
}