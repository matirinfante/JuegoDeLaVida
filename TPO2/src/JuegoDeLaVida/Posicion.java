/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JuegoDeLaVida;

import Juego_De_La_Vida_2.*;

/**
 *
 * @author Kurito
 */
public class Posicion {

    private int x, y;

    public Posicion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String toString() {
        String cadena = "Fila: " + x + "\nColumna: " + this.y;
        return cadena;
    }
    @Override
     public boolean equals(Object posicion)
    {
        boolean SonIguales = false;

        if (posicion != null && posicion instanceof Posicion)
        {
            SonIguales = (this.x == ((Posicion) posicion).x) && (this.y == ((Posicion) posicion).y);
        }

        return SonIguales;
    }
}
