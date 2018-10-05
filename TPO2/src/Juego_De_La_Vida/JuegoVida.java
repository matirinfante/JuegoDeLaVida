/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego_De_La_Vida;

import java.util.concurrent.RecursiveAction;

public class JuegoVida extends RecursiveAction {

    private final int primero;
    private final int ultimo;
    private final Tablero tablero;

    //Cantidad de elementos por tarea
    private final int EPT = 100;

    //Constructor
    public JuegoVida(Tablero tab, int prim, int ult) {
        this.primero = prim;
        this.ultimo = ult;
        this.tablero = tab;
    }

    public void Jugar() {
        //System.out.println(this.primero);
        if ((this.ultimo - this.primero) < this.EPT) {
            //System.out.println("Entro!!!!");
            for (int i = this.primero; i < this.ultimo; i++) {
                for (int j = this.primero; j < this.ultimo; j++) {
                    tablero.analizarCelula(i, j);
                }
            }

            //System.out.println(tablero.aCadenaBooleano());
            for (int i = this.primero; i < this.ultimo; i++) {
                for (int j = this.primero; j < this.ultimo; j++) {
                    tablero.cambiarEstadoCelula(i, j);
                }
            }

        }

    }

    @Override
    protected void compute() {
        //System.out.println(this.primero);
        if ((this.ultimo - this.primero) < this.EPT) {
            //System.out.println("Entro!!!!");
            for (int i = this.primero; i < this.ultimo; i++) {
                for (int j = this.primero; j < this.ultimo; j++) {
                    tablero.analizarCelula(i, j);
                }
            }

            for (int i = this.primero; i < this.ultimo; i++) {
                for (int j = this.primero; j < this.ultimo; j++) {
                    tablero.cambiarEstadoCelula(i, j);
                }
            }

        }

    }
}
