/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Control.Controlador;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author hgabr
 */
public class ParImpar extends Triangulo{

    public ParImpar(int size, ArrayList<JLabel> estructura) {
        super(size, estructura);
    }

    
    @Override
    public void Funcion() {
        for (JLabel current : Controlador.estructura) {
            current.setOpaque(true);
            if (Integer.valueOf(current.getText())%2 == 0)
                current.setBackground(Color.red);
            else
                current.setBackground(Color.GREEN);
        }
    }
    
}
