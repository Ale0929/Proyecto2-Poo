/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.Random;
import java.awt.Color;
/**
 *
 * @author Wess
 */
public final class Bola extends Thread{

    private int x;
    private int y;
    private int limite;
    private int resultado;
    private boolean derecha;
    private boolean contado;
    private Color color;
    private boolean initialized;
    
    /**
     * Constructor de la clase
     * @param CantidadRows 
     * Se encarga de inicializar los valores basicos de la bola.
     * Le asigna un color aleatorio derivado del azul, para que
     * se pueda mostrar con mayor claridad la trayectoria de cada bola. 
     */
    
    public Bola(int CantidadRows){
        this.limite = CantidadRows*32;
        this.x=0;
        this.y=6;
        contado = false;
        Random rand = new Random();       
        int cL = rand.nextInt(4 - 1 + 1) + 1;
        switch(cL){
            case 1:
                color = new Color(2, 119, 189);
                break;
            case 2:
                color = Color.BLUE;
                break;
            case 3:
                color = new Color(0, 0, 180);
                break;
            case 4:
              color = new Color(0, 127, 255);
                break;
        }
        this.setPriority(1);
    }
    
    @Override
    public void run(){
        Random rd = new Random();
        while(y!= limite+6){
            derecha = rd.nextBoolean();
            if (derecha){
                for(int i = 8; i>0; i--){
                    x +=4;
                    y +=4;
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException ex) {
                    }
                }
            }
            else{
                for(int i = 8; i>0; i--){
                    x -= 4;
                    y +=4;
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException ex) {
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

