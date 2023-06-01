/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.GUI;

import controller.Controller;
import java.awt.Color;
import javax.swing.BorderFactory;
import java.util.ArrayList;
import java.awt.Component;

import deepspace.HangarToUI;
import deepspace.ShieldToUI;
import deepspace.WeaponToUI;
/**
 *
 * @author crist
 */
public class HangarView extends javax.swing.JPanel {

    /**
     * Creates new form HangarView
     */
    public HangarView() {
        initComponents();
    }
    
    public void setHangar(HangarToUI h){
        if(h == null){
            setVisible(false);
        }
        else{
            panel_hangar.removeAll();
            String title = "Hangar con " + h.getMaxElements() + " lugares";
            panel_hangar.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), title));
            
            ArrayList<WeaponToUI> weapons = h.getWeapons();
            ArrayList<ShieldToUI> shieldBoosters = h.getShieldBoosters();
        
            for(WeaponToUI w : weapons){
                WeaponView weaponView = new WeaponView();
                weaponView.setWeapon(w);
                panel_hangar.add(weaponView);
            }
        
            for(ShieldToUI s : shieldBoosters){
                ShieldView shieldView = new ShieldView();
                shieldView.setShield(s);
                panel_hangar.add(shieldView);
            }
        }
        repaint();
        revalidate();
    }
    
    void getSelectedInHangar(ArrayList<Integer> weaponsSelected, ArrayList<Integer> shieldsSelected){
        int numWeapons = Controller.getInstance().getUIversion().getCurrentStation().getHangar().getWeapons().size();
        int numShields = Controller.getInstance().getUIversion().getCurrentStation().getHangar().getShieldBoosters().size();
        
        
        for(int i=0; i<numWeapons; i++){
            Component c = panel_hangar.getComponent(i);
            if(((CombatElementView) c).isSelected()){
                weaponsSelected.add(i);
            }
        }
        
        for(int i=0; i<numShields; i++){
            Component c = panel_hangar.getComponent(i+numWeapons);
            if(((CombatElementView) c).isSelected()){
                shieldsSelected.add(i);
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll_hangar = new javax.swing.JScrollPane();
        panel_hangar = new javax.swing.JPanel();

        scroll_hangar.setBorder(null);
        scroll_hangar.setViewportView(panel_hangar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll_hangar, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(scroll_hangar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel_hangar;
    private javax.swing.JScrollPane scroll_hangar;
    // End of variables declaration//GEN-END:variables
}
