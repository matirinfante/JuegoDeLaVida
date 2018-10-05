package Juego_De_La_Vida;

import java.util.Random;

public class Tablero {

    //Variables
    private final int DIMENSION = 10; //Dimension del tablero
    private final int[][] tablero;
    private boolean[][] modify;

    //Constructor
    public Tablero() {
        this.tablero = new int[this.DIMENSION][this.DIMENSION];
        this.modify = new boolean[this.DIMENSION][this.DIMENSION];
        inicializar();
    }

    public final void inicializar() {

        for (int i = 0; i < this.DIMENSION; i++) {
            for (int j = 0; j < this.DIMENSION; j++) {
                this.tablero[i][j] = new Random().nextInt(2);
                this.modify[i][j] = false;
            }
        }
    }

    public int dimension() {
        return this.DIMENSION;
    }

    public void analizarCelula(int fila, int columna) {
        int actual = this.tablero[fila][columna];

        int contarVivas = 0;
        int aux1, aux2;
        boolean cambio;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {

                if (!(i == 0 && j == 0)) {
                    aux1 = fila + i;
                    aux2 = columna + j;

                    //Si es el 
                    if (aux1 < 0) {
                        aux1 += this.DIMENSION;
                    }

                    if (aux1 >= this.DIMENSION) {
                        aux1 -= this.DIMENSION;
                    }

                    if (aux2 < 0) {
                        aux2 += this.DIMENSION;
                    }

                    if (aux2 >= this.DIMENSION) {
                        aux2 -= this.DIMENSION;
                    }

                    if (this.tablero[aux1][aux2] == 1) {
                        contarVivas++;
                    }

                } //if

            } //for j

        }//for i
        //System.out.print(actual + " ");
        //System.out.print(contarVivas + " ");
        //System.out.println("");
        //Si la celula esta viva
        if (actual == 1) {
            //System.out.println("ESTA VIVA");
            if (contarVivas == 2 || contarVivas == 3) {
                //Si no tiene 2 o 3 celulas vivas cambia su estado (muere)
                this.modify[fila][columna] = false;
                //System.out.println("NO CAMBIO");
            } else {
                this.modify[fila][columna] = true;
                //System.out.println("CAMBIO");
            }

        } else { //Si la celula esta muerta
            if (contarVivas == 3) {
                //Si tiene 3 celulas vivas cambia su estado (vive)
                this.modify[fila][columna] = true;
                //System.out.println("CAMBIO");
            } else {
                this.modify[fila][columna] = false;
                //System.out.println("NO CAMBIO");
            }
        }

    }

    public void cambiarEstadoCelula(int fila, int columna) {
        if (this.modify[fila][columna]) {

            if (this.tablero[fila][columna] == 1) {
                this.tablero[fila][columna] = 0;
            } else {
                this.tablero[fila][columna] = 1;
            }
            this.modify[fila][columna] = false;
        }

    }

    //Debug
    public String aCadena() {
        String s = "";
        for (int i = 0; i < this.DIMENSION; i++) {
            for (int j = 0; j < this.DIMENSION; j++) {
                s += this.tablero[i][j] + " ";
            }
            s += "\n";
        }
        return s;
    }

    public String aCadenaBooleano() {
        String s = "";
        for (int i = 0; i < this.DIMENSION; i++) {
            for (int j = 0; j < this.DIMENSION; j++) {
                s += this.modify[i][j] + " ";
            }
            s += "\n";
        }
        return s;
    }

}
