/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author hgabr
 */
public abstract class Triangulo {
    private int size;
    private ArrayList<JLabel> estructura;

    public Triangulo(int size, ArrayList<JLabel> estructura) {
        this.size = size;
        this.estructura = estructura;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ArrayList<JLabel> getEstructura() {
        return estructura;
    }

    public void setEstructura(ArrayList<JLabel> estructura) {
        this.estructura = estructura;
    }
    
    public abstract void Funcion();
    
}
