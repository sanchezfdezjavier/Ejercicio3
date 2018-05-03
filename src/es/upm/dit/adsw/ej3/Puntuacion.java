package es.upm.dit.adsw.ej3;

import java.awt.*;
import java.util.TreeMap;

/*
@author Javier Sanchez Fernandez
 */

/**
 * Contador de puntuacion.
 *
 * @author jose a. manas
 * @version 8-4-2018
 */
public class Puntuacion extends java.lang.Object implements java.lang.Runnable, Screen.Thing{

    // Atributos
    private final Font font;
    private int puntos;

    /**
     * Constructor.
     */
    public Puntuacion() {
        font = new Font("SansSerif", Font.BOLD, 18);
        puntos = 100;
        Game.getScreen().add(this);
    }

    /**
     * Suma puntos.
     *
     * @param n a sumar.
     */
    public synchronized void increment(int n) {
        puntos += n;
    }

    /**
     * Resta puntos.
     *
     * @param n a restar.
     */
    public synchronized void decrement(int n) {
        puntos -= n;
        if (puntos < 0) {
            Game.getSerpent().quit();
            Game.setState(Game.FINISHED);
        }
    }

    /**
     * Cada segundo resta 1 punto.
     */
    @Override
    public void run() {
        try{
            while(Game.getState() != Game.FINISHED){
                Nap.sleep(1000);
                this.decrement(1);
            }
        }catch (Exception e){

        }
    }

    /**
     * Se imprime en pantalla.
     *
     * @param g pantalla.
     */
    @Override
    public synchronized void paint(Graphics2D g) {
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString("puntos: " + puntos, 10, 20);
    }
}
