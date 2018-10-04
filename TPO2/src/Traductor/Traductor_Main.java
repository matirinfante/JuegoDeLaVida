package Traductor;

import java.util.Random;
import java.util.concurrent.*;

public class Traductor_Main {

    public static void main(String[] args) {
        String cadena = "Este es un mensaje de prueba de la encriptacion AJJAJA xd 1234";
        Mensaje mensaje = new Mensaje (cadena);
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
