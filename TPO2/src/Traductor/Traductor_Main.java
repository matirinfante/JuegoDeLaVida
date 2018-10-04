package Traductor;

import java.util.Random;
import java.util.concurrent.*;

public class Traductor_Main {

    public static void main(String[] args) {

        Mensaje mensaje = new Mensaje ("Este es un mensaje de prueba de la encriptacion AJJAJA xd 1234");
        /* Muestra el arreglo antes de realizar la accion
        
        System.out.print("Arreglo: {");
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + ", ");
        }
        System.out.print(" }");
        
         */
        Traductor tarea = new Traductor(mensaje , 0, mensaje.longitud());
        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(tarea);
        do {
            System.out.println("Threads activas: " + pool.getActiveThreadCount());
            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!tarea.isDone());
        pool.shutdown();

        if (tarea.isCompletedNormally()) {
            System.out.println("El proceso se ha completado normalmente");
        }
        System.out.println("MENSAJE ENCRIPTADO: ");
        System.out.println(mensaje.getCadena());

    }
}
