package JuegoDeLaVida;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JuegoDeLaVida {

    public static void main(String[] args) throws InterruptedException {

        Tablero tablero = new Tablero();
        int cantFilas = Tablero.CANTFILAS;
        boolean modo = true;

        ExecutorService executor = Executors.newFixedThreadPool(cantFilas / 2);

        System.out.println(tablero.mostrarTablero());
        System.out.println("\u001B[34m▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");

        Set<Callable<Tarea>> tareas = new HashSet();

        for (int i = 0; i < cantFilas; i++) {
            tareas.add(new Tarea(tablero, i, i, modo));
        }

        while (true) {
            executor.invokeAll(tareas);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(JuegoDeLaVida.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (!modo) {
                System.out.println(tablero.mostrarTablero());
                System.out.println("\u001B[34m▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
            }
            modo = !modo;
            for (Callable<Tarea> tarea : tareas) {
                ((Tarea) tarea).setModo(modo);
            }

        }

    }
    //executor.shutdown();
}
