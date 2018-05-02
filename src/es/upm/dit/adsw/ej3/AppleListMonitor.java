package es.upm.dit.adsw.ej3;

import java.util.LinkedList;

public class AppleListMonitor {

    LinkedList<Apple> appleList= new LinkedList<>();

    //Constructor
    public AppleListMonitor(){

    }

    // Tenemos una manzana mas.
    public void add(Apple apple){
        this.appleList.add(apple);
    }

    // Tenemos una manzana menos.
    public void remove(Apple apple){
        this.appleList.remove(apple);
    }

    // Informa si hay alguna manzana cerca del segmento p1-p2.
    public Apple getCloseApple(XY P1, XY P2){
        Apple manzanaResultado= null;

        // Que se considera cerca?

        return manzanaResultado;

    }

    //Actua sobre una menzana dentro del segmento p1-p2.
    public Apple hitCloseApple (XY P1, XY P2){
        Apple manzanaResultado= null;

        // Que se considera cerca?

        return manzanaResultado;
    }
}
