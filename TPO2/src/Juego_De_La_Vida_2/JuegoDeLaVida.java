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
public class JuegoDeLaVida {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Motor manejadorDeHilos = new Motor();
//        Tablero tablero = new Tablero();
//        
//        for (int i = 0; i < 4; i++) {
//            Tarea tarea = new Tarea(false, false, tablero, i, i);
//            manejadorDeHilos.ejecutaTarea(tarea);
//        }
        Celula[][] celulas = new Celula[6][6];
        Posicion[][] cuadrantes = new Posicion[4][2];
        
        int cantFilas = celulas.length;
        int cantColumnas = celulas[0].length;

        Posicion[] erCuadrante = new Posicion[2];
        erCuadrante[0] = new Posicion(0, 0);
        erCuadrante[1] = new Posicion((cantFilas / 2) - 1, (cantColumnas / 2) - 1); // accede a la posicion de la mitad mas uno
        cuadrantes[0] = erCuadrante;
        

        Posicion[] segundoCuadrante = new Posicion[2];
        segundoCuadrante[0] = new Posicion(0, ((cantFilas / 2) - 1) + 1);
        segundoCuadrante[1] = new Posicion((((cantFilas / 2) - 1)), ((cantFilas ) - 1)); // accede a la posicion de la mitad mas uno
        cuadrantes[0] = segundoCuadrante;
        //manejadorDeHilos.terminaServidor();
        System.out.println(segundoCuadrante[0].toString());
        System.out.println(segundoCuadrante[1].toString());
    }

}
