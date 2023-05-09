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
public class Diagonal extends Triangulo{
    //private Controlador controlador = MainWindow.controlador;
    
    public Diagonal(int size, ArrayList<JLabel> estructura) {
        super(size, estructura);
    }

    
    @Override
    public void Funcion() {
        ArrayList<ArrayList<Integer>> triangle = Controlador.triangleDimension;
        
        Color[] diagonalColors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.PINK, Color.MAGENTA, Color.CYAN, Color.LIGHT_GRAY, Color.DARK_GRAY};

        // Loop through the ArrayList of ArrayLists of Integers and modify the background color of each diagonal element
        for (int i = 0; i < triangle.size(); i++) {
            ArrayList<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                int value = row.get(j);
                // Calculate the row and column indices of the diagonal element
                int rowIdx = i;
                int colIdx = j;
                // Check if the diagonal index is valid
                int diagonalIndex = rowIdx - colIdx;
                if (diagonalIndex >= 0 && diagonalIndex < diagonalColors.length) {
                    // Modify the background color of the corresponding JLabel
                    if (!Controlador.estructura.get(i * (i + 1) / 2 + j).isOpaque()) { // check if the background color has already been set
                        Controlador.estructura.get(i * (i + 1) / 2 + j).setOpaque(true);
                    }
                    Controlador.estructura.get(i * (i + 1) / 2 + j).setBackground(diagonalColors[diagonalIndex]);
                }
            }
        }
    }
    
}
