/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Control.Controlador;
import static Vista.EscogerOperacion.trianglePanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author hgabr
 */
public class SumaHorizontal extends Triangulo{

    public SumaHorizontal(int size, ArrayList<JLabel> estructura) {
        super(size, estructura);
    }

    
    
    @Override
    public void Funcion() {
        System.out.println("llegue");
        JPanel sumasPanel = new JPanel(null);
        sumasPanel.setBackground(Color.WHITE);
        ArrayList<ArrayList<Integer>> pascalTriangle = Controlador.triangleDimension;
        ArrayList<Integer> rowSums = new ArrayList<>();

        //consigue sumatorias
        for (ArrayList<Integer> row : pascalTriangle) {
            int sum = 0;
            for (int num : row) {
                sum += num;
            }
            rowSums.add(sum);
        }
        
        //coloca los resultados graficamente
        int x = 50;
        int y = 25;
        int i = 0;
        int width = 50;
        int height = 50;
        
        for (Integer rowSum : rowSums) {
            JLabel label = new JLabel(String.valueOf(rowSum));
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setBounds(x, y + i * height, width, height);
            label.setOpaque(true);
            sumasPanel.add(label);
            i+=1;
        }
        Controlador.mainPanel.add(sumasPanel, BorderLayout.WEST);
    }
    
}
