/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Vista;

import Vista.Galton;
import javax.swing.JFrame;

/**
 *
 * @author Afase
 */
public class TestFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Galton galton = new Galton(6);
        JFrame frame = new JFrame();
        frame.setTitle("Galton Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(galton);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
