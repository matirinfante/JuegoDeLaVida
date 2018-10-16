package JuegoDeLaVida;

import java.util.concurrent.Callable;

public class Tarea implements Callable {

    // private boolean yaVerifico;
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

    public int getNroTarea() {
        return nroTarea;
    }

    public int getNroFila() {
        return nroFila;
    }

    /*
    public boolean isVerificando() {
        return yaVerifico;
    }
     */
    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    private void verificar() {
//        System.out.println(this.nroFila + " Fila");
        // System.out.println(">>>>>>>>ANALIZANDO FILA: " + (this.nroFila + 1));
        for (int j = 0; j < Tablero.CANTCOLUMNAS; j++) {
            // System.out.println("+[CELULA] FILA: " + (this.nroFila + 1) + " COLUMNA: " + (j + 1));
            verificarCelulasAlrededor(new Posicion(nroFila, j));
        }
    }

    private void modificar() {
        for (int j = 0; j < Tablero.CANTCOLUMNAS; j++) {
            Celula objCelula = tablero.getCelula(new Posicion(nroFila, j));

            if (objCelula.getdebeCambiar()) {
                //System.out.println("MODIFICANDO CELULA - FILA: " + (this.nroFila + 1) + " COLUMNA: " + (j + 1));
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
                        //System.out.println("*****Celula en FILA= " + (pos.getX() + 1) + " COLUMNA=" + (pos.getY() + 1) + " TIENE " + contarVivas + " CELULAS VIVAS ALREDEDOR");
                    }
                }
            }
        }
        if (celula.getEstado()) {
            //System.out.println("ESTA VIVA");
            if (!(contarVivas == 2 || contarVivas == 3)) {
                this.tablero.getCelulas()[pos.getX()][pos.getY()].debeCambiar();
                //System.out.println("Celula en FILA= " + (pos.getX() + 1) + " COLUMNA=" + (pos.getY() + 1) + " CAMBIO!! SE MUERE !! TIENE " + contarVivas + " CELULAS VIVAS ALREDEDOR");
            }

        } else { //Si la celula esta muerta
            if (contarVivas == 3) {
                //Si tiene 3 celulas vivas cambia su estado (vive)
                this.tablero.getCelulas()[pos.getX()][pos.getY()].debeCambiar();
                //System.out.println("Celula en FILA= " + (pos.getX() + 1) + " COLUMNA=" + (pos.getY() + 1) + " CAMBIO!! AHORA VIVE!! TIENE " + contarVivas + " CELULAS VIVAS ALREDEDOR");
            }
        }
    }

    /*
    private void cambiarEstadoCelula(Tablero tablero, Posicion pos) {
        Celula celula = tablero.getCelula(pos);
        celula.setEstado(!celula.getEstado());
    }
     */
    @Override
    public Object call() throws Exception {
        //variable verificando y cambiando hay que hacerlos como variable compartida
        if (this.verificar) {
            this.verificar();
        } else {
            this.modificar();
        }
        return null;
    }
}
