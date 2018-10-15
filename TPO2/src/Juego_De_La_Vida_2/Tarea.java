/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorioprogramacion;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kurito
 */
public class Tarea implements Runnable {

    private boolean yaVerifico;
    private Tablero tablero;
    private int nroFila;
    private int nroTarea;
    private Manager variable;

    public Tarea(Manager variable, Tablero tablero, int nroFila, int nroTarea) {
        this.tablero = tablero;
        this.nroFila = nroFila;
        this.nroTarea = nroTarea;
        this.variable = variable;
    }

    public int getNroTarea() {
        return nroTarea;
    }

    public int getNroFila() {
        return nroFila;
    }

    public Manager getVariable() {
        return variable;
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
        while (true) {
            try {
                variable.verificando(nroFila);
                this.verificar();
                Thread.sleep(4000);
                variable.terminoVerificar();

                variable.modificando(nroFila);
                this.modificar();
                Thread.sleep(4000);
                variable.terminoModificar();
            } catch (InterruptedException ex) {
                Logger.getLogger(Tarea.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void verificar() {
//        System.out.println(this.nroFila + " Fila");
        for (int j = 0; j < Tablero.CANTCOLUMNAS; j++) {
            verificarCelulasAlrededor(new Posicion(nroFila, j));
        }
    }

    private void modificar() {
        for (int j = 0; j < Tablero.CANTCOLUMNAS; j++) {
            Celula objCelula = tablero.getCelula(new Posicion(nroFila, j));
            if (objCelula.getdebeCambiar()) {
                objCelula.setEstado(!objCelula.getEstado());
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
