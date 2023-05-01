/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Modelo.Bola;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.*;

/**
 *
 * @author Afase
 */

public final class Galton extends JPanel implements ActionListener{
    private Bola[] bolas;
    private final int numeroBolas = 300;
    private int tamaño;
    private Timer timer;
    private int currentBola;
    private int resultados[];
    
    public Galton(int columns) throws InterruptedException{
        this.tamaño = columns;
        resultados = new int[columns+1];
        currentBola = 0;
        this.setPreferredSize(new Dimension(32*tamaño*2+ 64, 32*tamaño + 128));
        timer = new Timer(35, this);
        bolas = new Bola[numeroBolas];
        for (int i=0; i<numeroBolas; i ++){
            bolas[i] = new Bola(tamaño);
        }
        for (int i=0; i<resultados.length; i ++){
            resultados[i] = 0;
        }
        timer.start();
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.BLACK);
        int start = this.getWidth()/2;
        int y;
        int cantidad = 1;
        for(int i = 0; i< tamaño ;i++){
            int x = start;
            y = 32*i + 32;
            for(int j = 0; j< cantidad ;j++){
                g2D.fillRect(x, y, 6, 6);
                x += 64;
            }
            start -=32;
            cantidad +=1; 
        }
        for (Bola bola : bolas) {
            if (bola.isAlive()) {
                g2D.setColor(bola.getColor());
                int Bx = bola.getX()+ this.getWidth()/2;
                int By = bola.getY();
                g2D.fillOval(Bx, By, 16, 16);
            }
        }
        for(int i= 0; i< resultados.length; i ++){
            String valor = Integer.toString(resultados[i]);
            g2D.setColor(Color.BLACK);
            g2D.drawString(valor, i*64+32, tamaño*32);
            
            g2D.setColor(Color.GREEN);
            g2D.fillRect(i*64+16, tamaño*32 + 5, 32, 2*resultados[i]);
            
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        if(currentBola< bolas.length){
            bolas[currentBola].start();
            bolas[currentBola].setInitialiced(true);
            currentBola++;
        }
        for (Bola bola : bolas) {
            if (!bola.isAlive() && !bola.isContado() && bola.isInitialiced()) {
                    int Bx = bola.getX()+tamaño*32;
                    Bx = Bx/2/32;
                    resultados[Bx] +=1; 
                    bola.setContado(true);
                    System.out.println(Arrays.toString(resultados));
            }
        }
    }
}