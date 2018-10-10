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
public class Tablero {

    private Celula[][] celulas;
    private static final int CANTFILAS = 5;
    private static final int CANTCOLUMNAS = 5;
    private boolean estaVerificando;
    private Posicion[][] cuadrantes;

    public Tablero() {
        this.celulas = new Celula[CANTFILAS][CANTCOLUMNAS];
        this.cuadrantes = new Posicion[4][2];
        this.calcularCuadrantes();
    }

    private void calcularCuadrantes() {
        int cantFilas = this.celulas.length;
        int cantColumnas = this.celulas[0].length;
        if (cantFilas % 2 != 0) { //Para matrices con longitud impar
            Posicion[] erCuadrante = new Posicion[2];
            erCuadrante[0] = new Posicion(0, 0);
            erCuadrante[1] = new Posicion((cantFilas / 2), cantFilas / 2); // accede a la posicion de la mitad mas uno
            cuadrantes[0] = erCuadrante;

            Posicion[] doCuadrante = new Posicion[2];
            doCuadrante[0] = new Posicion((cantColumnas / 2) + 1, cantColumnas - 1);
            doCuadrante[1] = new Posicion((cantFilas / 2) + 1, (cantFilas / 2) + 1);
            cuadrantes[1] = doCuadrante;

            Posicion[] tercerCuadrante = new Posicion[2];
            tercerCuadrante[0] = new Posicion((cantColumnas / 2) + 1, cantColumnas - 1);
            tercerCuadrante[1] = new Posicion((cantFilas / 2) + 1, (cantFilas / 2) + 1);
            cuadrantes[1] = tercerCuadrante;

        } else {
            Posicion[] erCuadrante = new Posicion[2];
            erCuadrante[0] = new Posicion(0, 0);
            erCuadrante[1] = new Posicion((cantFilas / 2) - 1, (cantColumnas / 2) - 1); // accede a la posicion de la mitad mas uno
            cuadrantes[0] = erCuadrante;
            
            Posicion[] segundoCuadrante = new Posicion[2];
            segundoCuadrante[0] = new Posicion(0, ((cantFilas / 2) - 1) + 1);
            segundoCuadrante[1] = new Posicion( (((cantFilas / 2) - 1)), ((cantFilas / 2) - 1) + 1); // accede a la posicion de la mitad mas uno
            cuadrantes[0] = segundoCuadrante;
        }
    }

    public Celula getCelula(Posicion pos) {
        return this.celulas[pos.getX()][pos.getY()];
    }

    public Celula getCelula(int x, int y) {
        return this.celulas[x][y];
    }

    public Celula[][] getCelulas() {
        return celulas;
    }

    public static int getCANTFILAS() {
        return CANTFILAS;
    }

    public static int getCANTCOLUMNAS() {
        return CANTCOLUMNAS;
    }

}
