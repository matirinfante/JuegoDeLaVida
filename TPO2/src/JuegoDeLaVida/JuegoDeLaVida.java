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
        int cantFilas = Tablero.getCANTFILAS();
        boolean modo = true;
        int cantTareas = cantFilas/2;
        ExecutorService executor = Executors.newFixedThreadPool(cantTareas);

        System.out.println(tablero.mostrarTablero());
        System.out.println("\u001B[34m▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");

        Set<Callable<Tarea>> tareas = new HashSet();

        for (int i = 0; i < cantFilas; i++) {
            tareas.add(new Tarea(tablero, i, i, modo));
        }
        int cantEjecuciones = 5 * 2;
        int i = 0;
        while (i <= cantEjecuciones) {
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
            i++;
        }
        executor.shutdown();
        System.out.println("**************************************");
        System.out.println("*********FIN DE LA EJECUCION**********");
        System.out.println("**************************************");
        System.out.println("CANTIDAD DE VIVAS: " + tablero.getCantVivas());
        System.out.println("CANTIDAD DE MUERTAS: " + tablero.getCantMuertas());
        System.out.println("CANTIDAD DE EJECUCIONES: "+ cantEjecuciones/2);
        System.out.println("CANTIDAD DE TAREAS: "+ cantTareas );
        System.out.println("\u001B[34m▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
    }

}
