/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorioprogramacion;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Kurito
 */
public class Manager {

    public boolean estaverificando;
    public boolean estaCambiando;
    public int hilosActual = 0;

    private Semaphore mutex;
    private Semaphore verificando;
    private Semaphore modificando;

    public Manager() {
        this.modificando = new Semaphore(0);
        this.verificando = new Semaphore(Tablero.CANTFILAS);
        this.mutex = new Semaphore(1);
    }

    public void verificando(int cuadrante) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " esperando para verificar.");
        verificando.acquire();
        System.out.println(Thread.currentThread().getName() + " está en verificando la fila " + (cuadrante + 1));

        System.out.println("Cant Hilo " + hilosActual);

    }

    public void terminoVerificar() throws InterruptedException {
        mutex.acquire();
        hilosActual += 1;
        if (hilosActual == Tablero.CANTFILAS) {
            hilosActual = 0;
            this.liberarParaVerificar();

        }
        mutex.release();
        System.out.println(Thread.currentThread().getName() + " terminó de verificar.");

    }

    public void modificando(int cuadrante) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " esperando para modificar.");
        verificando.acquire();
        System.out.println(Thread.currentThread().getName() + " está en modificando la fila " + (cuadrante + 1));

//        System.out.println("Cant Hilo " + hilosActual);

    }

    public void terminoModificar() throws InterruptedException {
        mutex.acquire();
        hilosActual += 1;
        if (hilosActual == Tablero.CANTFILAS) {
            hilosActual = 0;
            this.liberarParaVerificar();
        }
        mutex.release();
        System.out.println(Thread.currentThread().getName() + " terminó de verificar.");

    }

    public void liberarParaModificar() {
        this.modificando.release(Tablero.CANTFILAS);
    }

    public void liberarParaVerificar() {
        this.verificando.release(Tablero.CANTFILAS);
    }
}
