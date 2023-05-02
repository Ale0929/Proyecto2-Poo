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
 * @author Wess
 */

public final class Galton extends JPanel implements ActionListener{
    private Bola[] bolas;
    private final int numeroBolas = 300;
    private int tamaño;
    private Timer timer;
    private int currentBola;
    private int resultados[];
    private JFrame frame;
    
    public Galton(int columns){ //Metodo constructor.
        this.tamaño = columns;
        resultados = new int[columns+1];
        currentBola = 0;
        this.setPreferredSize(new Dimension(32*tamaño*2+ 64, 32*tamaño + 200));
        timer = new Timer(35, this);
        bolas = new Bola[numeroBolas];
        for (int i=0; i<numeroBolas; i ++){
            bolas[i] = new Bola(tamaño);
        }
        for (int i=0; i<resultados.length; i ++){
            resultados[i] = 0;
        }
        timer.start();
        frame = new JFrame(); //Esto es para crear un frame que contenga a este panel. Si quieres, puedes meter este
        frame.setTitle("Galton Simulation"); //panel dentro del frame de seleccionar operacion. pero no lo recomiendo
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);        //Aunque si quieres, debes borrrar este JFrame
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    @Override
    public void paint(Graphics g){  //Paint method.
        super.paint(g);             //Se usa para dibujar cualquier cosa en el panel.
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.BLACK);
        int start = this.getWidth()/2;
        int y;
        int cantidad = 1;
        for(int i = 0; i< tamaño ;i++){ //Ciclo para dibujar los "cuadritos" que componen al triangulo
            int x = start;
            y = 32*i + 32;
            for(int j = 0; j< cantidad ;j++){
                g2D.fillRect(x, y, 6, 6);
                x += 64;
            }
            start -=32;
            cantidad +=1; 
        }
        for (Bola bola : bolas) {  // Revisa la posicion de las bolas y el color que tienen para
            if (bola.isAlive()) {  // dibujarlas en el grafico
                g2D.setColor(bola.getColor());
                int Bx = bola.getX()+ this.getWidth()/2;
                int By = bola.getY();
                g2D.fillOval(Bx, By, 16, 16);
            }
        }
        for(int i= 0; i< resultados.length; i ++){  //este otro loop se usa para graficar los resultados de la
            String valor = Integer.toString(resultados[i]);// prueba. Genera una grafica sencilla con cuadros.
            g2D.setColor(Color.BLACK);
            g2D.drawString(valor, i*64+32, tamaño*32);
            g2D.setColor(Color.GREEN);
            g2D.fillRect(i*64+16, tamaño*32 + 5, 32, 2*resultados[i]);
            
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {// Cada 0.05 segundos o 30 veces por segundo(~30fps)
        repaint();                              // se actualizan los graficos y la posicion de las bolas
        if(currentBola< bolas.length){
            bolas[currentBola].start();
            bolas[currentBola].setInitialiced(true);
            currentBola++;
        }
        for (Bola bola : bolas) {   //Revisa la posicion de las bolas y el color que tienen.
            if (!bola.isAlive() && !bola.isContado() && bola.isInitialiced()) {
                    int Bx = bola.getX()+tamaño*32;
                    Bx = Bx/2/32;
                    resultados[Bx] +=1; 
                    bola.setContado(true);
            }
        }
    }
    
    public static void main (String[] args){ // Para pruebas
        Galton galton = new Galton(9);//Para instanciar, agrega el tamaño que tiene el triangulo.
    }
}
