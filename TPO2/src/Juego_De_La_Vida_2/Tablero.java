/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorioprogramacion;

import java.util.ArrayList;
import java.util.Random;

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
        this.llenarMatriz();
        this.generarAleatoriamente();
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
            erCuadrante[1] = new Posicion((cantFilas / 2) - 1, (cantColumnas / 2) - 1);
            cuadrantes[0] = erCuadrante;

            Posicion[] segundoCuadrante = new Posicion[2];
            segundoCuadrante[0] = new Posicion(0, ((cantFilas / 2) - 1) + 1);
            segundoCuadrante[1] = new Posicion((((cantFilas / 2) - 1)), ((cantFilas) - 1));
            cuadrantes[1] = segundoCuadrante;

            Posicion[] tercerCuadrante = new Posicion[2];
            tercerCuadrante[0] = new Posicion(((cantFilas / 2)), 0);
            tercerCuadrante[1] = new Posicion(cantFilas - 1, (cantColumnas / 2) - 1);
            cuadrantes[2] = tercerCuadrante;

            Posicion[] cuartoCuadrante = new Posicion[2];
            cuartoCuadrante[0] = new Posicion(((cantFilas / 2)), (cantColumnas / 2));
            cuartoCuadrante[1] = new Posicion(cantFilas - 1, cantColumnas - 1);
            cuadrantes[3] = cuartoCuadrante;
        }
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
            x = rand.nextInt(5 - 1 + 1) + 1;
            y = rand.nextInt(5 - 1 + 1) + 1;
            Posicion posicionNueva = new Posicion(x, y);
            if (!posiciones.contains(new Posicion(x, y))) {
                while (posiciones.contains(posicionNueva)) {
                    x = rand.nextInt(5 - 1 + 1) + 1;
                    y = (int) rand.nextInt(5 - 1 + 1) + 1;
                    posicionNueva = new Posicion(x, y);

                }
                posiciones.add(posicionNueva);
            } else {
                posiciones.add(posicionNueva);
            }
        }
        posiciones.forEach((posicion) -> {
            celulas[posicion.getX()-1][posicion.getY()-1] = new Celula(0, true);
        });
    }

    public Celula getCelula(int x, int y) {
        return this.celulas[x][y];
    }

    public Celula[][] getCelulas() {
        return celulas;
    }

    public Posicion[] getCuadrante(int cuadrante) {
        return this.cuadrantes[cuadrante];
    }

    public static int getCANTFILAS() {
        return CANTFILAS;
    }

    public static int getCANTCOLUMNAS() {
        return CANTCOLUMNAS;
    }

    private void llenarMatriz() {
        int nroCelula = 1;
        for(int i=0; i < CANTFILAS ; i++){
            for(int j=0; j < CANTCOLUMNAS;j++ ){
                celulas[i][j] = new Celula(nroCelula,false);
                nroCelula++;
            }
        }
        
    }

}
