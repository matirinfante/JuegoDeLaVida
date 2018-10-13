/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorioprogramacion;

/**
 *
 * @author Kurito
 */
public class Manager{

    public boolean estaverificando;
    public boolean estaCambiando;
    public int hilosActual = 0;

    public Manager() {
        this.estaCambiando = false;
        this.estaverificando = false;
    }

    public synchronized void terminoTarea() {
        hilosActual++;
    }

    public void resetCantHilos() {
        hilosActual = 0;
    }

    public synchronized boolean isEstaverificando() {
        return estaverificando;
    }

    public void setEstaverificando(boolean estaverificando) {
        this.estaverificando = estaverificando;
    }

    public boolean isEstaCambiando() {
        return estaCambiando;
    }

    public void setEstaCambiando(boolean estaCambiando) {
        this.estaCambiando = estaCambiando;
    }
}
