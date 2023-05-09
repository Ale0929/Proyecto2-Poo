/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Control.Controlador;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author hgabr
 */
public class Simetria extends Triangulo{

    public Simetria(int size, ArrayList<JLabel> estructura) {
        super(size, estructura);
    }

    
    
    @Override
    public void Funcion() {
        // Tamaño y altura del JPanel que contiene los JLabels del triangulo
        int panelWidth = Controlador.trianglePanel.getWidth();
        int panelHeight = Controlador.trianglePanel.getHeight();

        // Crea dos rectangulos para representar las dos mitades del triangulo
        Rectangle leftRect = new Rectangle(0, 0, panelWidth / 2, panelHeight);
        Rectangle rightRect = new Rectangle(panelWidth / 2, 0, panelWidth / 2, panelHeight);

        // Colores de los rectagulos
        Color leftColor = new Color(0, 0, 255, 100); // Blue color with 40% transparency
        Color rightColor = new Color(255, 0, 0, 100); // Red color with 40% transparency

        // Graficos del JPanel que contiene los JLabels del triangulo
        Graphics2D g2d = (Graphics2D) Controlador.trianglePanel.getGraphics();

        // Setea la transparencia
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));

        // Pinta los rectangulos
        g2d.setColor(leftColor);
        g2d.fillRect(leftRect.x, leftRect.y, leftRect.width, leftRect.height);
        g2d.setColor(rightColor);
        g2d.fillRect(rightRect.x, rightRect.y, rightRect.width, rightRect.height);

        // Transparencia
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
    } 
}
