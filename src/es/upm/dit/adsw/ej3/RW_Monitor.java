package es.upm.dit.adsw.ej3;

import java.lang.*;

/*
@author Javier Sanchez Fernandez
 */


/*Es la clase que implementa el mecanismo de lectores-escritores.
        Los nombres de los métodos vienen en el javadoc.
        Este monitor hay que usarlo en varios sitios para proteger las variables locales a la vez que se
        permite la máxima concurrencia (readers) siempre y cuando no haya que modificar los datos
        críticos (writers).
        • Lo usa la clase Serpent, que se da hecha.
        • Debe usarlo la clase AppleListMonitor que la escribe el usuario.
*/

public class RW_Monitor  extends RW_Monitor_0 {

    private int numWriters=0;
    private int numWritersWaiting=0;
    private int numReaders=0;

    // Constructor
    public RW_Monitor(){

    }

    // Getter
    @Override
    public synchronized int getNReadersIn(){
        return this.numReaders;
    }

    // Getter
    @Override
    public synchronized int getNWritersIn(){
        return this.numWriters;
    }

    // Solicitud de permiso para hacer una lectura. El thread que llama se queda esperando hasta que pueda entrar.
    @Override
    public synchronized void openReading(){
        try{
            // Revisar condicion
            while(numWriters > 0 || numReaders >= 1){
                wait();
            }
            }catch (InterruptedException e){

            }
            numReaders++;
    }

    // Devuelve el permiso de lectura.
    @Override
    public synchronized void closeReading() throws IllegalMonitorStateException{
        if(numReaders <= 0){
            throw new IllegalMonitorStateException();
        }
        numReaders--;
        notifyAll();
    }

    // Solicitud de permiso para hacer una escritura. El thread que llama se queda esperando hasta que pueda entrar.
    @Override
    public synchronized void openWriting(){
        numWritersWaiting++;
        while(numReaders > 0 || numWriters >0){
            // Este try-catch puede estar mal.
            try {
                wait();
            }catch(InterruptedException e){

            }
        }
        numWritersWaiting--;
        numWriters++;
    }

    @Override
    public synchronized void closeWriting() throws IllegalMonitorStateException{
        if(numWriters <= 0){
            throw new IllegalMonitorStateException();
        }
        numWriters--;
        notifyAll();
    }
}
