/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorioprogramacion;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * @author Kurito
 */
public class Motor {

    private int cantHilos;
    private int cantHilosActivos;

    private ThreadPoolExecutor executor;

    public Motor(int cantHilos) {
        this.cantHilos = cantHilos;
        this.cantHilosActivos = 0;
        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(this.cantHilos);//Crea el objeto executor o un pool de threads  
    }

    public Motor() {
        this.cantHilosActivos = 0;
        this.cantHilos = 4;
        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(this.cantHilos);//Crea el objeto executor o un pool de threads  
    }

    public void ejecutaTarea(Tarea tarea) {
        executor.execute(tarea);// Ejecuta una tarea 
    }
    
//    public void esperarTareas(){
//        executor.invokeAll(null);
//    }

    public void terminaServidor() {
        executor.shutdown();// Este metodo termina el executor  
    }
}
