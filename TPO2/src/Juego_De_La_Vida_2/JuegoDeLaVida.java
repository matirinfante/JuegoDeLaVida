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
        Celula[][] celulas = new Celula[4][4];
        Posicion[][] cuadrantes = new Posicion[4][2];

        int cantFilas = celulas.length;
        int cantColumnas = celulas[0].length;

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
        cuartoCuadrante[0] = new Posicion(((cantFilas / 2)), (cantColumnas / 2) );
        cuartoCuadrante[1] = new Posicion(cantFilas - 1, cantColumnas - 1);
        cuadrantes[3] = cuartoCuadrante;

        //manejadorDeHilos.terminaServidor();
        System.out.println(erCuadrante[0].toString());
        System.out.println(erCuadrante[1].toString());
        System.out.println(" ------------- - - -- - -");

        System.out.println(segundoCuadrante[0].toString());
        System.out.println(segundoCuadrante[1].toString());

        System.out.println(" ------------- - - -- - -");
        System.out.println(tercerCuadrante[0].toString());
        System.out.println(tercerCuadrante[1].toString());
        System.out.println(" ------------- - - -- - -");
        
        System.out.println(cuartoCuadrante[0].toString());
        System.out.println(cuartoCuadrante[1].toString());
        System.out.println(" ------------- - - -- - -");
    }

}
