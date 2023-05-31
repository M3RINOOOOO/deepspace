/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;
import View.DeepSpaceView;
import View.GUI.MainWindow;
import controller.Controller;
import deepspace.GameUniverse;
/**
 *
 * @author cristobalmer
 */
public class PlayWithGUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GameUniverse game = new GameUniverse();
        DeepSpaceView view = MainWindow.getInstance();
        Controller controller = Controller.getInstance();
        controller.setModelView(game, view);
        controller.start();
    }
    
}
