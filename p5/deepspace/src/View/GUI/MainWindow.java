/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.GUI;
import View.DeepSpaceView;
import controller.Controller;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import deepspace.GameState;


import deepspace.SpaceStationToUI;  //BORRAR
import deepspace.CardDealer;       //QUITAR PUBLIC A LA CLASE Y BORRAR
import deepspace.SpaceStation;       //QUITAR PUBLIC A LA CLASE Y EL CONSTRUCTOR Y BORRAR
                                    //QUITAR PUBLIC AL TOUI DE WEAPON


/**
 *
 * @author Sergio
 */
public class MainWindow extends javax.swing.JFrame implements DeepSpaceView{

    
    private static MainWindow instance = null;
    
    private String appName = "DeepSpace";
    private SpaceStationView spaceStationView;
    private EnemyStarShipView enemyView;
    

    public static MainWindow getInstance () {
      if (instance == null) {
        instance = new MainWindow();
      }
      return instance;
    }
    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        setTitle (appName);
        spaceStationView = new SpaceStationView();
        enemyView = new EnemyStarShipView();
        currentStation.add(spaceStationView);
        Enemigo.add(enemyView);
        repaint();
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                Controller.getInstance().finish(0);
            }
        });
        
        
        
    }
    
    @Override
    public void updateView(){      
        
        spaceStationView.setSpaceStation(Controller.getInstance().getUIversion().getCurrentStation());
        spaceStationView.updateView();
        enemyView.setEnemy(Controller.getInstance().getUIversion().getCurrentEnemy());
        nextTurn.setEnabled(Controller.getInstance().getState() == GameState.AFTERCOMBAT);
        combat.setEnabled(Controller.getInstance().getState() == GameState.BEFORECOMBAT || Controller.getInstance().getState() == GameState.INIT);
    }
    
    @Override
    public ArrayList<String> readNamePlayers(){
        ReadName readNames = new ReadName(this);
        ArrayList<String> names = readNames.getNames();
        names.removeIf(e -> e.length() == 0);
        while(names.size()<2){
            errorInNamesMessage();
            names = readNames.getNames();
            names.removeIf(e -> e.length() == 0);
        }
        return names;

    }
     
     
    public void showView(){
        this.setVisible(true);
    }
    
    private void jbExitActionPerformed(java.awt.event.ActionEvent evt) {                                       
        Controller.getInstance().finish(0);
    }    
    
    @Override
    public boolean confirmExitMessage() {
        return (JOptionPane.showConfirmDialog(this, "¿Estás segur@ que deseas salir?", getAppName(), JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
    }
    
    
    public void errorInNamesMessage() {
        JOptionPane.showMessageDialog(this,"Se necesitan como mínimo dos jugadores","Error",JOptionPane.INFORMATION_MESSAGE);
    }
    
    
    public String getAppName() {
        return appName;
    }
    
    @Override
    public void nextTurnNotAllowedMessage() {
        JOptionPane.showMessageDialog(this, "No puedes avanzar de turno, \nno has cumplido tu castigo.", getAppName(), JOptionPane.ERROR_MESSAGE);
    }
    
    @Override
    public void lostCombatMessage() {
        JOptionPane.showMessageDialog(this, "Has PERDIDO el combate. \nCumple tu castigo.", getAppName(), JOptionPane.INFORMATION_MESSAGE);
    }
    
    @Override
    public void escapeMessage() {
        JOptionPane.showMessageDialog(this, "Has logrado ESCAPAR. \nEres un gallina espacial.", getAppName(), JOptionPane.INFORMATION_MESSAGE);
    }
    
    @Override
    public void wonCombatMessage() {
        JOptionPane.showMessageDialog(this, "Has GANADO el combate. \nDisfruta de tu botín.", getAppName(), JOptionPane.INFORMATION_MESSAGE);
    }
    
    @Override
    public void wonGameMessage() {
        JOptionPane.showMessageDialog(this, "ENHORABUENA!!. \nHas ganado el juego!!.", getAppName(), JOptionPane.INFORMATION_MESSAGE);
    }
    
    @Override
    public void conversionMessage() {
        if(Controller.getInstance().getUIversion().getCurrentEnemy().getLoot().isGetEfficient()){
            JOptionPane.showMessageDialog(this, "Has GANADO el combate. \nAdemás te has CONVERTIDO en una estación EFICIENTE. \nDisfruta de tu botín.", getAppName(), JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(this, "Has GANADO el combate. \nAdemás te has CONVERTIDO en una CIUDAD ESPACIAL. \nDisfruta de tu botín.", getAppName(), JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void noCombatMessage() {
        JOptionPane.showMessageDialog(this, "No puedes combatir en este momento.", getAppName(), JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nextTurn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        currentStation = new javax.swing.JPanel();
        combat = new javax.swing.JButton();
        Enemigo = new javax.swing.JPanel();
        exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nextTurn.setText("Siguiente Turno");
        nextTurn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextTurnActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(currentStation);

        combat.setText("Combatir");
        combat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combatActionPerformed(evt);
            }
        });

        exit.setText("Salir");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Enemigo, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nextTurn)
                        .addGap(18, 18, 18)
                        .addComponent(combat)
                        .addGap(18, 18, 18)
                        .addComponent(exit)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Enemigo, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextTurn)
                    .addComponent(combat)
                    .addComponent(exit))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextTurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextTurnActionPerformed
        // TODO add your handling code here:
        Controller.getInstance().nextTurn();
        updateView();
        
    }//GEN-LAST:event_nextTurnActionPerformed

    private void combatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combatActionPerformed
        // TODO add your handling code here:
        Controller.getInstance().combat();
         updateView();
    }//GEN-LAST:event_combatActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        Controller.getInstance().finish(0);
    }//GEN-LAST:event_exitActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Enemigo;
    private javax.swing.JButton combat;
    private javax.swing.JPanel currentStation;
    private javax.swing.JButton exit;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nextTurn;
    // End of variables declaration//GEN-END:variables
}
