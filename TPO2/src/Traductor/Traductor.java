package Traductor;

import static java.util.concurrent.ForkJoinTask.getQueuedTaskCount;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class Traductor extends RecursiveAction {

    //private final char[] arreglo;
    private final int primerElem;
    private final int ultimoElem;
    private final Mensaje mensaje;

    //Cantidad de elementos por tarea
    private final int EPT = 10;

    //Constructor
    public Traductor(Mensaje msj, int primer, int ultimo) {
        //this.clave = key; //Clave de encriptacion
        this.mensaje = msj; //Mensaje a encriptar
        this.primerElem = primer; //Primer elemento del arreglo
        this.ultimoElem = ultimo; //Ultimo elemento del arreglo

    }


    @Override
    protected void compute() {

        if (this.ultimoElem - this.primerElem < this.EPT) {
            rot47();
            //System.out.println("Completado de " + this.primerElem + ", al: " + this.ultimoElem);

        } else {

            int mitad = (this.ultimoElem + this.primerElem) / 2;
           // System.out.println("Tares pendientes: " + getQueuedTaskCount());

            Traductor subTarea1 = new Traductor(mensaje, this.primerElem, mitad + 1);
            Traductor subTarea2 = new Traductor(mensaje, mitad + 1, this.ultimoElem);
            subTarea1.fork();
            subTarea2.fork(); //Continua la ejecucion

            subTarea1.join(); //Espera el resultado
            subTarea2.join();
        }

    }

    private void rot47() {
        char c;
        for (int i = this.primerElem; i < this.ultimoElem; i++) {
            c = mensaje.getChar(i);
            if (c != ' ') {
                c += 47;
                if (c > '~') {
                    c -= 94;
                }

            }
            mensaje.setChar(c, i);
        }
    }

}
