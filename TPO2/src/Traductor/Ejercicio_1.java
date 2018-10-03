package Traductor;

import java.util.Random;
import java.util.concurrent.*;

public class Ejercicio_1 {

    public static void main(String[] args) {

        char arreglo[] = new char[1000];
        Random random = new Random();

        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (char) (random.nextInt(26) + 'a');
        }

        System.out.print("Arreglo: {");
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + ", ");
        }
        System.out.print(" }");

        TareaContarVocales tarea = new TareaContarVocales(arreglo, 0, arreglo.length);
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
        try {
            System.out.println("La cantidad de vocales en el arreglo es: " + tarea.get());
        } catch (Exception ex) {
            ex.printStackTrace();;
        }

    }
}
