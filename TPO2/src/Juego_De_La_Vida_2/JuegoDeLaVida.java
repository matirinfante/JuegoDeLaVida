/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorioprogramacion;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kurito
 */
public class JuegoDeLaVida {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Motor manejadorDeHilos = new Motor();
        Tablero tablero = new Tablero();
        Manager manager = new Manager();
        tablero.mostrarTablero();
        System.out.println("-----------------------------------------------");
        for (int i = 0; i < 4; i++) {
            Tarea tarea = new Tarea(manager, tablero, i, i);
            manejadorDeHilos.ejecutaTarea(tarea);
        }
        while (true) {
            if (manager.hilosActual == 4 || manager.hilosActual == 0) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(JuegoDeLaVida.class.getName()).log(Level.SEVERE, null, ex);
                }
                tablero.mostrarTablero();
                System.out.println("-----------------------------------------------");
            }
        }
    }

}
