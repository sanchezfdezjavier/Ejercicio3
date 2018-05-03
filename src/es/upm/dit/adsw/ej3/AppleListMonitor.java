package es.upm.dit.adsw.ej3;

import java.util.*;
import java.lang.*;

/*
@author Javier Sanchez Fernandez
 */

public class AppleListMonitor {

    private final List<Apple> appleList= new ArrayList<>();
    private final RW_Monitor_0 monitor_0= new RW_Monitor();



    //Constructor
    public AppleListMonitor(){}

    // Tenemos una manzana mas.
    public void add(Apple apple) {
        this.monitor_0.openWriting();
        this.appleList.add(apple);
        this.monitor_0.closeWriting();
    }

    // Tenemos una manzana menos.
    public void remove(Apple apple){
        this.monitor_0.openWriting();
        this.appleList.remove(apple);
        apple.quit();
        monitor_0.closeWriting();
    }

    // Informa si hay alguna manzana cerca del segmento p1-p2.
    public Apple getCloseApple(XY P1, XY P2){
        Apple manzanaResultado= null;
        for(Apple apple: this.appleList){
            if(apple.getXY().isCloseTo(P1, P2)){
                manzanaResultado = apple;
            }
        }
        return manzanaResultado;
    }

    //Actua sobre una menzana dentro del segmento p1-p2.
    public Apple hitCloseApple (XY P1, XY P2){
        try{
            monitor_0.openWriting();
            Apple apple= getCloseApple(P1, P2);
            if(apple != null){
                appleList.remove(apple);
                apple.quit();
            }
            return apple;
        // El ' finally' es 'como' el catch, salvo que se ejecuta siempre, aunque el try falle.
        }finally {
            monitor_0.closeWriting();
        }
    }
}
