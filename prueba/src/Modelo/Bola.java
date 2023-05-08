/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Color;
/**
 *
 * @author Afase
 */
public class Bola extends Thread{

    private int x;
    private int y;
    private int limite;
    private int resultado;
    private boolean derecha;
    private boolean contado;
    private Color color;
    private boolean initialized;
public final class Bola extends Thread{

    private int x;
    private int y;
    private int limite;
    private int resultado;
    private boolean derecha;
    private boolean contado;
    private Color color;
    private boolean initialized;
    
    public Bola(int CantidadRows){
        this.limite = CantidadRows*32;
        this.x=0;
        this.y=0;
        contado = false;
        color = Color.red;
//        Random rand = new Random();       
//        int cL;                             
//        cL = rand.nextInt(4 - 1 + 1) + 1;
//        switch(cL){
//            case 1:
//                color = Color.RED;
//                break;
//            case 2:
//                color = Color.ORANGE;
//                break;
//            case 3:
//                color = Color.BLUE;
//                break;
//            case 4:
//              color = Color.GRAY;
//                break;
//        }
    }
    
    @Override
    public void run(){
        Random rd = new Random();
        while(y!= limite){
            derecha = rd.nextBoolean();
            if (derecha){
                for(int i = 0; i<8; i++){
                    x +=4;
                    y +=4;
                    try {
                        Thread.sleep(35);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Bola.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            else{
                for(int i = 0; i<8; i++){
                    x -= 4;
                    y +=4;
                    try {
                        Thread.sleep(35);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Bola.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public int getResultado(){
        return resultado;
    }
    
    public boolean isContado() {
        return contado;
    }

    public void setContado(boolean contado) {
        this.contado = contado;
    }
    
    public Color getColor() {
        return color;
    }
    
    public void setColor(Color color){
        this.color = color;
    }
    
    public boolean isInitialiced(){
        return initialized;
    }
    public void setInitialiced(boolean initialized){
        this.initialized = initialized;
    }
}
