/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Modelo.TIPOTriangulo;
import Modelo.Triangulo;
import Vista.EscogerOperacion;
import Vista.Galton;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author hgabr
 */

public class Controlador {
    private Triangulo triangulo;
    public static ArrayList<JLabel> estructura = EscogerOperacion.labels;
    public static ArrayList<ArrayList<Integer>> triangleDimension = EscogerOperacion.triangleDimension;
    public static JPanel trianglePanel = EscogerOperacion.trianglePanel;
    public static JPanel mainPanel = EscogerOperacion.mainPanel;
    public static int size = EscogerOperacion.sizeTriangulo;

    public Controlador() {}
    
    /**
    *
    *
    */
    public void crearTriangulo() {
        triangulo = new Triangulo(size, estructura) {
            @Override
            public void Funcion() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
    }
    
    public void cambiarTriangulo(TIPOTriangulo tipo) {
        triangulo = Factory.getNewTriangulo(tipo, size, estructura); //revisar si es necesario el casting
    }
    
    public void ejecutarFuncion(TIPOTriangulo tipo) {
        cambiarTriangulo(tipo);
        if (triangulo instanceof Modelo.Simetria)
            trianglePanel.paint(trianglePanel.getGraphics());
        triangulo.Funcion();
    }
    
    public void empezarSimulacion() {
        new Galton(size);
    }
    
}
