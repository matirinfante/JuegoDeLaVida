/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego_De_La_Vida_2;

/**
 *
 * @author Kurito
 */
public class Tarea implements Runnable {

    private boolean verificando;
    private boolean cambiando;
    private Tablero tablero;
    private int cuadrante;
    private int nroTarea;

    public Tarea(boolean cambiando, boolean verificando, Tablero tablero, int cuadrante, int nroTarea) {
        this.cambiando = cambiando;
        this.verificando = verificando;
        this.tablero = tablero;
        this.cuadrante = cuadrante;
        this.nroTarea = nroTarea;
    }

    public int getNroTarea() {
        return nroTarea;
    }

    
    
    public int getCuadrante() {
        return cuadrante;
    }

    public void setCuadrante(int cuadrante) {
        this.cuadrante = cuadrante;
    }

    public boolean isVerificando() {
        return verificando;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public void setVerificando(boolean verificando) {
        this.verificando = verificando;
    }

    public boolean isCambiando() {
        return cambiando;
    }

    public void setCambiando(boolean cambiando) {
        this.cambiando = cambiando;
    }

    @Override
    public void run() {
        while (true) {
            while (verificando) {
                
            }

            while (cambiando) {

            }
        }
    }

    private void verificar() {

    }

    private void cambiarEstadoCelula(Tablero tablero, Posicion pos) {
        Celula celula = tablero.getCelula(pos); 
        celula.setEstado(!celula.getEstado());
    }

}
