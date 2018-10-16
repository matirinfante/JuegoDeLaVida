/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JuegoDeLaVida;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matias
 */
public class JuegoDeLaVida {

    public static void main(String[] args) throws InterruptedException {
        Tablero tablero = new Tablero();
        int cantFilas = Tablero.CANTFILAS, iteracion = 0;
        boolean modo = true;

        ExecutorService magia = Executors.newFixedThreadPool(cantFilas);

        tablero.mostrarTablero();
        System.out.println("-----------------------------------------------");

        while (true) {
            if (modo) {
                System.out.println("\tIteracion " + iteracion);
            }
            Set<Callable<Tarea>> tareas = new HashSet();
            iteracion++;
            for (int i = 0; i < cantFilas; i++) {
                tareas.add(new Tarea(tablero, i, i, modo));
            }

            magia.invokeAll(tareas);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(JuegoDeLaVida.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (!modo) {
                tablero.mostrarTablero();
                System.out.println("-----------------------------------------------");
            }
            modo = !modo;
        }
    }

}
