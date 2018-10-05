package Juego_De_La_Vida;

public class Tablero {

    //Variables
    private final int DIMENSION = 50; //Dimension del tablero
    private int[][] tablero;
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
                this.tablero[i][j] = (int) (Math.random() * 1);
                this.modify[i][j] = false;
            }
        }
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

        //Si la celular esta viva
        if (actual == 1) {
            if ( !(contarVivas == 2 || contarVivas == 3)) {
                actual = 0;
            } else {
                actual = 0;
            }

        } else {
            if (contarVivas == 3 ){
                actual = 1;
            }
        }

    }
    
    
    
}
