
package JuegoDeLaVida;

import java.util.ArrayList;
import java.util.Random;

public class Tablero {

    private Celula[][] celulas;
    public static final int CANTFILAS = 6;
    public static final int CANTCOLUMNAS = 6;
    private boolean estaVerificando;

    public Tablero() {
        this.celulas = new Celula[CANTFILAS][CANTCOLUMNAS];
        this.llenarMatriz();
        this.generarAleatoriamente();
    }

    public String mostrarTablero() {
        String estado = "";
        for (int i = 0; i < CANTFILAS; i++) {
            for (int j = 0; j < CANTFILAS; j++) {
                if (celulas[i][j].getEstado()) {
                    estado += "O";
                } else {
                    estado += "X";
                }
                estado += "  ";

            }
            estado += "\n";
        }
        return estado;
    }

    public Celula getCelula(Posicion pos) {
        return this.celulas[pos.getX()][pos.getY()];
    }

    public void generarAleatoriamente() {
        int celulasVivas = 10;
        ArrayList<Posicion> posiciones = new ArrayList();
        int x, y;

        for (int i = 0; i < celulasVivas; i++) {
            Random rand = new Random();
            x = rand.nextInt(CANTFILAS - 1 + 1) + 1;
            y = rand.nextInt(CANTCOLUMNAS - 1 + 1) + 1;
            Posicion posicionNueva = new Posicion(x, y);
            if (!posiciones.contains(new Posicion(x, y))) {
                while (posiciones.contains(posicionNueva)) {
                    x = rand.nextInt(CANTFILAS - 1 + 1) + 1;
                    y = rand.nextInt(CANTCOLUMNAS - 1 + 1) + 1;
                    posicionNueva = new Posicion(x, y);

                }
                posiciones.add(posicionNueva);
            } else {
                posiciones.add(posicionNueva);
            }
        }
        posiciones.forEach((posicion) -> {
            celulas[posicion.getX() - 1][posicion.getY() - 1] = new Celula(0, true);
        });
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

    private void llenarMatriz() {
        int nroCelula = 1;
        for (int i = 0; i < CANTFILAS; i++) {
            for (int j = 0; j < CANTCOLUMNAS; j++) {
                celulas[i][j] = new Celula(nroCelula, false);
                nroCelula++;
            }
        }

    }

}
