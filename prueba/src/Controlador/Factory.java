/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Modelo.Diagonal;
import Modelo.Fibonacci;
import Modelo.ParImpar;
import Modelo.Simetria;
import Modelo.SumaHorizontal;
import Modelo.TIPOTriangulo;
import Modelo.Triangulo;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author diego
 */
public class Factory {
    
    public static Triangulo getNewTriangulo(TIPOTriangulo tipo, int size, ArrayList<JLabel> estructura){
        
        switch (tipo) {
            case FIBONACCI:
                return new Fibonacci(size, estructura);
            case PAR_IMPAR:
                return new ParImpar(size, estructura);
            case DIAGONAL:
                return new Diagonal(size, estructura);
            case SIMETRIA:
                return new Simetria(size, estructura);
            case SUMA_HORIZONTAL:
                return new SumaHorizontal(size, estructura);
        }
        return null;
    }
    
    
}
