package JuegoDeLaVida;

import java.util.concurrent.Callable;

public class Tarea implements Callable {

    private Tablero tablero;
    private int nroFila;
    private int nroTarea;
    private boolean verificar;

    public Tarea(Tablero tablero, int nroFila, int nroTarea, boolean modo) {
        this.tablero = tablero;
        this.nroFila = nroFila;
        this.nroTarea = nroTarea;
        this.verificar = modo;
    }

    public void setModo(boolean mode) {
        this.verificar = mode;
    }

    public int getNroTarea() {
        return nroTarea;
    }

    public int getNroFila() {
        return nroFila;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    private void verificar() {
        for (int j = 0; j < Tablero.CANTCOLUMNAS; j++) {
            verificarCelulasAlrededor(new Posicion(nroFila, j));
        }
    }

    private void modificar() {
        for (int j = 0; j < Tablero.CANTCOLUMNAS; j++) {
            Celula objCelula = tablero.getCelula(new Posicion(nroFila, j));
            if (objCelula.getdebeCambiar()) {

                objCelula.setEstado(!objCelula.getEstado());
                objCelula.cambio();
            }
        }
    }

    public void verificarCelulasAlrededor(Posicion pos) {
        Celula celula = this.tablero.getCelula(pos);
        int contarVivas = 0;
        int aux1, aux2;
        int DIMENSION = this.tablero.getCelulas().length;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {

                if (i != 0 || j != 0) {
                    aux1 = pos.getX() + i;
                    aux2 = pos.getY() + j;

                    if (aux1 < 0) {
                        aux1 += DIMENSION;
                    }

                    if (aux1 >= DIMENSION) {
                        aux1 -= DIMENSION;
                    }

                    if (aux2 < 0) {
                        aux2 += DIMENSION;
                    }

                    if (aux2 >= DIMENSION) {
                        aux2 -= DIMENSION;
                    }

                    if (this.tablero.getCelulas()[aux1][aux2].getEstado()) {
                        contarVivas++;
                    }
                }
            }
        }
        if (celula.getEstado()) {
            if (!(contarVivas == 2 || contarVivas == 3)) {
                this.tablero.getCelulas()[pos.getX()][pos.getY()].debeCambiar();
            }

        } else { //Si la celula esta muerta
            if (contarVivas == 3) {
                this.tablero.getCelulas()[pos.getX()][pos.getY()].debeCambiar();
            }
        }
    }

    @Override
    public Object call() throws Exception {
        //variable verificando y cambiando hay que hacerlos como variable compartida
        if (this.verificar) {
            this.verificar();
            //this.setModo(false);
        } else {
            this.modificar();
            //this.setModo(true);
        }
        return null;
    }
}
