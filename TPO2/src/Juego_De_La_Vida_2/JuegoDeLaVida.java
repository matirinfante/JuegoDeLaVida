/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorioprogramacion;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Kurito
 */
public class JuegoDeLaVida {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Motor manejadorDeHilos = new Motor();
//        Tablero tablero = new Tablero();
//        Manager manager = new Manager();
//        while (true) {
//            
//            if (manager.hilosActual == 4 || manager.hilosActual == 0) {
//                for (int i = 0; i < 4; i++) {
//                    Tarea tarea = new Tarea(manager, tablero, i, i);
//                    manejadorDeHilos.ejecutaTarea(tarea);
//                }
//            }
//
//        }

        int celulasVivas = 10;
        ArrayList<Posicion> posiciones = new ArrayList();
        int x, y;

        for (int i = 0; i < celulasVivas; i++) {
            Random rand = new Random();
            x = rand.nextInt(5 - 1 + 1) + 1;
            y = rand.nextInt(5 - 1 + 1) + 1;
            Posicion posicionNueva = new Posicion(x, y);
            if (posiciones.contains(new Posicion(x, y))) {
                while (posiciones.contains(posicionNueva)) {
                    x = rand.nextInt(5 - 1 + 1) + 1;
                    y = (int) rand.nextInt(5 - 1 + 1) + 1;
                    posicionNueva = new Posicion(x, y);

                }
                posiciones.add(posicionNueva);
            } else {
                posiciones.add(posicionNueva);
            }
        }
        for (Posicion posicione : posiciones) {
            System.out.println(posicione);
        }
    }

}
