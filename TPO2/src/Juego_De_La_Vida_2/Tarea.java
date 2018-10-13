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
public class Tarea implements Runnable {

    private boolean yaVerifico;
    private Tablero tablero;
    private int nroCuadrante;
    private int nroTarea;
    private Manager variable;

    public Tarea(Manager variable, Tablero tablero, int cuadrante, int nroTarea) {
        this.tablero = tablero;
        this.nroCuadrante = cuadrante;
        this.nroTarea = nroTarea;
        this.variable = variable;
    }

    public int getNroTarea() {
        return nroTarea;
    }

    public int getNroCuadrante() {
        return nroCuadrante;
    }

    public void setNroCuadrante(int cuadrante) {
        this.nroCuadrante = cuadrante;
    }

    public boolean isVerificando() {
        return yaVerifico;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    @Override
    public void run() {
        //variable verificando y cambiando hay que hacerlos como variable compartida
        Posicion[] cuadrante = tablero.getCuadrante(this.nroCuadrante);
        if (variable.isEstaverificando()) {
            for (int i = cuadrante[0].getX(); i < cuadrante[0].getY(); i++) {
                for (int j = cuadrante[1].getX(); j < cuadrante[1].getY(); j++) {
                    verificarCelulasAlrededor(new Posicion(i, j));
                }
            }
        } else {
            for (int i = cuadrante[0].getX(); i < cuadrante[0].getY(); i++) {
                for (int j = cuadrante[1].getX(); j < cuadrante[1].getY(); j++) {
                    Celula objCelula = tablero.getCelula(new Posicion(i, j));
                    if (objCelula.getdebeCambiar()) {
                        objCelula.setEstado(!objCelula.getEstado());
                    }
                }
            }

        }
        variable.terminoTarea();
    }

    private void verificar() {

    }

    public void verificarCelulasAlrededor(Posicion pos) {

        Celula celula = this.tablero.getCelula(pos);
        int contarVivas = 0;
        int aux1, aux2;
        int DIMENSION = this.tablero.getCelulas().length;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
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
        if (celula.getEstado()) {
            //System.out.println("ESTA VIVA");
            if (!(contarVivas == 2 || contarVivas == 3)) {
                this.tablero.getCelulas()[pos.getX()][pos.getY()].debeCambiar();
                //System.out.println("CAMBIO");
            }

        } else { //Si la celula esta muerta
            if (contarVivas == 3) {
                //Si tiene 3 celulas vivas cambia su estado (vive)
                this.tablero.getCelulas()[pos.getX()][pos.getY()].debeCambiar();
                //System.out.println("CAMBIO");
            }
        }
    }

    private void cambiarEstadoCelula(Tablero tablero, Posicion pos) {
        Celula celula = tablero.getCelula(pos);
        celula.setEstado(!celula.getEstado());
    }
}
