package es.upm.dit.adsw.ej3;

import java.lang.*;

public class RW_Monitor {

    // Constructor
    public RW_Monitor(){

    }

    // Getter
    public int getNReadersIn(){
        int readersNum= 0;


        return readersNum;
    }

    // Getter
    public int getNWritersIn(){
        int writersNum=0;

        return writersNum;
    }

    // Solicitud de permiso para hacer una lectura. El thread que llama se queda esperando hasta que pueda entrar.
    public void openReading(){

    }

    // Devuelve el permiso de lectura.
    public void closeReading() throws IllegalMonitorStateException{
        try{
            //Codigo
        }catch(IllegalMonitorStateException e){
           System.out.println("Error en  el metodo 'closeWriting' de la clase 'RW_Monitor'");
        }
    }

    // Solicitud de permiso para hacer una escritura. El thread que llama se queda esperando hasta que pueda entrar.
    public void openWriting(){

    }

    public void closeWriting() throws IllegalMonitorStateException{
        try{
            //Codigo
        }catch(IllegalMonitorStateException e){
            System.out.println("Error en el método 'closeWriting' de la clase 'RW_Monitor");
        }
    }
}
