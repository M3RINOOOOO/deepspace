/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.GUI;

import deepspace.LootToUI;

/**
 *
 * @author crist
 */
public class LootView extends javax.swing.JPanel {

    /**
     * Creates new form LootView
     */
    public LootView() {
        initComponents();
    }
    
    void setLoot(LootToUI loot){
        numero_armas.setText(Integer.toString(loot.getnWeapons()));
        numero_escudos.setText(Integer.toString(loot.getnShields()));
        numero_hangar.setText(Integer.toString(loot.getnHangars()));
        numero_combustible.setText(Integer.toString(loot.getnSupplies()));
        numero_medallas.setText(Integer.toString(loot.getnMedals()));
        repaint();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo_armas = new javax.swing.JLabel();
        titulo_escudos = new javax.swing.JLabel();
        titulo_hangar = new javax.swing.JLabel();
        titulo_combustible = new javax.swing.JLabel();
        titulo_medallas = new javax.swing.JLabel();
        numero_armas = new javax.swing.JLabel();
        numero_escudos = new javax.swing.JLabel();
        numero_hangar = new javax.swing.JLabel();
        numero_combustible = new javax.swing.JLabel();
        numero_medallas = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Botín"));

        titulo_armas.setText("Armas :");

        titulo_escudos.setText("Escudos :");

        titulo_hangar.setText("Tamaño de hangar : ");

        titulo_combustible.setText("Combustible :");

        titulo_medallas.setText("Medallas :");

        numero_armas.setText("jLabel6");

        numero_escudos.setText("jLabel7");

        numero_hangar.setText("jLabel8");

        numero_combustible.setText("jLabel9");

        numero_medallas.setText("jLabel10");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titulo_armas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(numero_armas))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titulo_escudos)
                            .addComponent(titulo_hangar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numero_hangar)
                            .addComponent(numero_escudos))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titulo_combustible)
                    .addComponent(titulo_medallas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(numero_medallas)
                    .addComponent(numero_combustible))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titulo_armas)
                    .addComponent(titulo_combustible)
                    .addComponent(numero_armas)
                    .addComponent(numero_combustible))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titulo_escudos)
                    .addComponent(titulo_medallas)
                    .addComponent(numero_escudos)
                    .addComponent(numero_medallas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titulo_hangar)
                    .addComponent(numero_hangar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel numero_armas;
    private javax.swing.JLabel numero_combustible;
    private javax.swing.JLabel numero_escudos;
    private javax.swing.JLabel numero_hangar;
    private javax.swing.JLabel numero_medallas;
    private javax.swing.JLabel titulo_armas;
    private javax.swing.JLabel titulo_combustible;
    private javax.swing.JLabel titulo_escudos;
    private javax.swing.JLabel titulo_hangar;
    private javax.swing.JLabel titulo_medallas;
    // End of variables declaration//GEN-END:variables
}