package Juego_De_La_Vida;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class JuegoVida_Main {

    public static void main(String[] args) {

        Tablero tablero = new Tablero();
        System.out.println(tablero.aCadena());
        //System.out.println(tablero.aCadenaBooleano());

        JuegoVida tarea = new JuegoVida(tablero, 0, 10);
        //tarea.Jugar();
        /**/

        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(tarea);
        do {
            try {
                TimeUnit.MILLISECONDS.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!tarea.isDone());
        pool.shutdown();

        //System.out.println(tablero.aCadenaBooleano());
        System.out.println(tablero.aCadena());
    }
}
