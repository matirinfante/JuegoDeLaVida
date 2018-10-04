package Traductor;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.*;

public class Traductor_Main {

    public static void main(String[] args) {
        Mensaje mensaje = new Mensaje();
        String contraseña = "1234";
        String password;
        String cadena = "";
        Scanner scanner = new Scanner(System.in);
        int opcion;
        boolean salir = false;
        boolean enviado = false;
        while (!salir) {
            menu();
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                
                case 1: //Enviar Mensaje
                    if (!enviado){
                    System.out.println("Ingrese el mensaje que desea enviar: ");
                    cadena = scanner.nextLine();
                    mensaje = new Mensaje(cadena);
                    System.out.println("Ingrese la contraseña de encriptacion ");
                    password = scanner.nextLine();
                    if (password.equals(contraseña)) {

                        Traductor tarea = new Traductor(mensaje, 0, mensaje.longitud());
                        ForkJoinPool pool = new ForkJoinPool();
                        pool.execute(tarea);
                        do {
                            // System.out.println("Threads activas: " + pool.getActiveThreadCount());
                            try {
                                TimeUnit.MILLISECONDS.sleep(5);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } while (!tarea.isDone());
                        pool.shutdown();

                        System.out.println("Mensaje Enviado");
                    } else {
                        System.out.println("Contraseña Incorrecta");
                        mensaje.setCadena("");
                    }//if else
                    enviado = true;
                    }else{
                        System.out.println("Ya ha enviado un mensaje");
                    }
                    break;
                    
                case 2: //Ver Mensaje Enviado
                    if (!enviado) {
                        System.out.println("Primero debe enviar un mensaje");
                    } else {
                        System.out.println("MENSAJE : " + mensaje.getCadena());
                    }
                    break;
                case 3: //Desencriptar Mensaje
                    if (enviado) {
                        System.out.println("Ingrese la contraseña de encriptacion ");
                        password = scanner.next();
                        if (password.equals(contraseña)) {

                            Traductor tarea = new Traductor(mensaje, 0, mensaje.longitud());
                            ForkJoinPool pool = new ForkJoinPool();
                            pool.execute(tarea);
                            do {
                                //System.out.println("Threads activas: " + pool.getActiveThreadCount());
                                try {
                                    TimeUnit.MILLISECONDS.sleep(5);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            } while (!tarea.isDone());
                            pool.shutdown();
                        } else {
                            System.out.println("Contraseña Incorrecta");
                        }
                    } else {
                        System.out.println("Aun no se ha enviado ningun mensaje");
                    }
                    break;
                case 4: //Cambiar Contraseña
                    System.out.println("Ingrese la contraseña actual");
                    password = scanner.next();
                    if (password.equals(contraseña)) {
                        System.out.println("Ingrese la nueva contraseña");
                        contraseña = scanner.next();
                    } else {
                        System.out.println("Contraseña Incorrecta");
                    }
                    break;
                case 5: //Salir
                    System.out.println("Adios");
                    salir = true;

            }//Switch
        }//While
    }//Main

    public static void menu() {
        System.out.println("+---------------------------------------+");
        System.out.println("|       Seleccione a una opcion         |");
        System.out.println("+---------------------------------------+");
        System.out.println("| 1 - Enviar mensaje                    |");
        System.out.println("| 2 - Ver Mensaje                       |");
        System.out.println("| 3 - Desencriptar Mensaje              |");
        System.out.println("| 4 - Cambiar Contraseña de encriptacion|");
        System.out.println("| 5 - Salir                             |");
        System.out.println("+---------------------------------------+");
    }

}
