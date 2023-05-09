/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

/**
 *
 * @author hgabr
 */

import Control.Controlador;
import Modelo.TIPOTriangulo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//EL MAXIMO DE NIVELES ES 10

public class EscogerOperacion {
    private final Controlador controlador = MainVentana.controlador;
    private final JFrame mainWindow;
    public JFrame frame;
    public static JPanel trianglePanel = new JPanel(null);
    public static JPanel mainPanel = new JPanel(new BorderLayout());
    public static int sizeTriangulo = 0;
    public static ArrayList<JLabel> labels = new ArrayList<JLabel>();
    public static ArrayList<ArrayList<Integer>> triangleDimension = new ArrayList<>();
    
    
    public EscogerOperacion(int sizeTriangulo, JFrame mainWindow) {
        this.sizeTriangulo = sizeTriangulo;
        this.mainWindow = mainWindow;
        createPascalTriangle();
    }
    
    public void createPascalTriangle(){
        frame = new JFrame("Pascal Triangle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        
        mainPanel.setBackground(Color.WHITE);
        frame.add(mainPanel);
        
        trianglePanel.setBackground(Color.WHITE);
        mainPanel.add(trianglePanel, BorderLayout.CENTER);
        
        int x = 282;
        int y = 25;
        int width = 50;
        int height = 50;
        int corrimiento = 25;
        for (int i = 0; i < sizeTriangulo; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                int num = calculateBinomialCoefficient(i, j);
                row.add(num);
                JLabel label = new JLabel(String.valueOf(num));
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setBounds(x + j * width - i*corrimiento, y + i * height, width, height);
                trianglePanel.add(label);
                labels.add(label);
            }
            triangleDimension.add(row);
        }
        
        JPanel buttonPanel = new JPanel(new GridLayout(8, 1));
        buttonPanel.setBackground(Color.WHITE);
        mainPanel.add(buttonPanel, BorderLayout.EAST);
        
        JButton btnFibonacci = new JButton("Fibonacci");
        JButton btnParImpar = new JButton("ParImpar");
        JButton btnDiagonal = new JButton("Diagonal");
        JButton btnSimetria = new JButton("Simetria");
        JButton btnSumaHorizontal = new JButton("SumaHorizontal");
        JButton btnGalton = new JButton("Tabla de Galton");
        JButton btnResetear = new JButton("Resetear Triangulo");
        JButton btnAtras = new JButton("Atras");
        
        //BOTON FIBONACCI
        btnFibonacci.setBackground(new java.awt.Color(51, 153, 255));
        btnFibonacci.setFont(new java.awt.Font("Baskerville Old Face", 1, 20)); // NOI18N
        btnFibonacci.setForeground(new java.awt.Color(0, 0, 0));
        btnFibonacci.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        //btnFibonacci.setSize(100, 50); //usar si quitamos el gridLayout
        btnFibonacci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFibonacciActionPerformed(evt);
            }
        });
        
        //BOTON PARIMPAR
        btnParImpar.setBackground(new java.awt.Color(51, 153, 255));
        btnParImpar.setFont(new java.awt.Font("Baskerville Old Face", 1, 20)); // NOI18N
        btnParImpar.setForeground(new java.awt.Color(0, 0, 0));
        btnParImpar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        //btnParImpar.setSize(100, 50); //usar si quitamos el gridLayout
        btnParImpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParImparActionPerformed(evt);
            }
        });
        
        //BOTON DIAGONAL
        btnDiagonal.setBackground(new java.awt.Color(51, 153, 255));
        btnDiagonal.setFont(new java.awt.Font("Baskerville Old Face", 1, 20)); // NOI18N
        btnDiagonal.setForeground(new java.awt.Color(0, 0, 0));
        btnDiagonal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        //btnDiagonal.setSize(100, 50); //usar si quitamos el gridLayout
        btnDiagonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiagonalActionPerformed(evt);
            }
        });
        
        //BOTON SIMETRIA
        btnSimetria.setBackground(new java.awt.Color(51, 153, 255));
        btnSimetria.setFont(new java.awt.Font("Baskerville Old Face", 1, 20)); // NOI18N
        btnSimetria.setForeground(new java.awt.Color(0, 0, 0));
        btnSimetria.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        //btnSimetria.setSize(100, 50); //usar si quitamos el gridLayout
        btnSimetria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimetriaActionPerformed(evt);
            }
        });
        
        //BOTON SUMA HORIZONTAL
        btnSumaHorizontal.setBackground(new java.awt.Color(51, 153, 255));
        btnSumaHorizontal.setFont(new java.awt.Font("Baskerville Old Face", 1, 20)); // NOI18N
        btnSumaHorizontal.setForeground(new java.awt.Color(0, 0, 0));
        btnSumaHorizontal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        //btnSumaHorizontal.setSize(100, 50); //usar si quitamos el gridLayout
        btnSumaHorizontal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSumaHorizontalActionPerformed(evt);
            }
        });
        
        //BOTON GALTON
        btnGalton.setBackground(new java.awt.Color(51, 153, 255));
        btnGalton.setFont(new java.awt.Font("Baskerville Old Face", 1, 20)); // NOI18N
        btnGalton.setForeground(new java.awt.Color(0, 0, 0));
        btnGalton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        //btnGalton.setSize(100, 50); //usar si quitamos el gridLayout
        btnGalton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGaltonActionPerformed(evt);
            }
        });
        
        //BOTON RESETEAR
        btnResetear.setBackground(new java.awt.Color(51, 153, 255));
        btnResetear.setFont(new java.awt.Font("Baskerville Old Face", 1, 20)); // NOI18N
        btnResetear.setForeground(new java.awt.Color(0, 0, 0));
        btnResetear.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        //btnResetear.setSize(100, 50); //usar si quitamos el gridLayout
        btnResetear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetearActionPerformed(evt);
            }
        });
        
        //BOTON ATRAS
        btnAtras.setBackground(new java.awt.Color(255, 153, 153));
        btnAtras.setFont(new java.awt.Font("Baskerville Old Face", 1, 20)); // NOI18N
        btnAtras.setForeground(new java.awt.Color(0, 0, 0));
        btnAtras.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        //btnAtras.setSize(100, 50); //usar si quitamos el gridLayout
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        
        buttonPanel.add(btnFibonacci);
        buttonPanel.add(btnParImpar);
        buttonPanel.add(btnDiagonal);
        buttonPanel.add(btnSimetria);
        buttonPanel.add(btnSumaHorizontal);
        buttonPanel.add(btnGalton);
        buttonPanel.add(btnResetear);
        buttonPanel.add(btnAtras);
        
        frame.setVisible(true);
    }
    
    //setea el numero que va en el "nodo (cuadro)" del triangulo de pascal
    private static int calculateBinomialCoefficient(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        } else {
            return calculateBinomialCoefficient(n - 1, k - 1) + calculateBinomialCoefficient(n - 1, k);
        }
    }
    
    private void ejecutarFuncion(TIPOTriangulo tipo) {
        controlador.ejecutarFuncion(tipo);
    }
    
    //BOTONES
    private void btnFibonacciActionPerformed(java.awt.event.ActionEvent evt) {
        ejecutarFuncion(TIPOTriangulo.FIBONACCI);
    }
    
    private void btnParImparActionPerformed(java.awt.event.ActionEvent evt) {
        frame.repaint();
        ejecutarFuncion(TIPOTriangulo.PAR_IMPAR);
    }
    
    private void btnDiagonalActionPerformed(java.awt.event.ActionEvent evt) {
        frame.repaint();
        ejecutarFuncion(TIPOTriangulo.DIAGONAL);
    }
    
    private void btnSimetriaActionPerformed(java.awt.event.ActionEvent evt) {
        for (JLabel label : labels) {
            label.setBackground(Color.white);
        }
        ejecutarFuncion(TIPOTriangulo.SIMETRIA);
    }
    
    private void btnSumaHorizontalActionPerformed(java.awt.event.ActionEvent evt) {
        ejecutarFuncion(TIPOTriangulo.SUMA_HORIZONTAL);
    }
    
    private void btnGaltonActionPerformed(java.awt.event.ActionEvent evt) {
        frame.dispose();
        controlador.empezarSimulacion();
    }
    
    private void btnResetearActionPerformed(java.awt.event.ActionEvent evt) {
        for (JLabel label : labels) {
            label.setBackground(Color.white);
        }
        frame.repaint();
    }
    
    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {
        frame.dispose();
        mainWindow.setVisible(true);
    }
}