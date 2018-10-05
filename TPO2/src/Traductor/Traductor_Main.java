package Traductor;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.*;
import javax.swing.JOptionPane;

public class Traductor_Main {

    public static void main(String[] args) {
        //Testeando github en linux
        //Declaracion de Variables
        Mensaje mensaje = new Mensaje();
        String contraseña = "1234"; //Contraseña por defecto
        String password;
        String cadena = "";
        //Scanner scanner = new Scanner(System.in);
        int opcion;
        boolean salir = false;
        boolean enviado = false;

        //MENU
        while (!salir) {
            //menu();
            //opcion = scanner.nextInt();
            //scanner.nextLine();
            String op = JOptionPane.showInputDialog("Seleccione a una opcion\n1- Enviar Mensaje\n2- Ver Mensaje\n3- Desencriptar Mensaje\n4- Cambiar Contraseña\n5- Salir");
            opcion = Integer.parseInt(op);
            switch (opcion) {
                case 1: //Enviar Mensaje
                    if (!enviado) {
                        //System.out.println("Ingrese el mensaje que desea enviar: ");
                        //cadena = scanner.nextLine();
                        cadena = JOptionPane.showInputDialog("Ingrese el mensaje que desea enviar");
                        mensaje = new Mensaje(cadena);
                        //System.out.println("Ingrese la contraseña de encriptacion ");
                        //password = scanner.nextLine();
                        password = JOptionPane.showInputDialog("Ingrese la contraseña de encriptacion ");
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

                            //System.out.println("Mensaje Enviado");
                            JOptionPane.showMessageDialog(null, "Mensaje Enviado: " + mensaje.getCadena());
                            enviado = true;
                        } else {
                            //System.out.println("Contraseña Incorrecta");
                            JOptionPane.showMessageDialog(null, "Contraseña Incorrecta");
                            mensaje.setCadena("");
                        }//if else

                    } else {
                        JOptionPane.showMessageDialog(null, "Ya ha enviado un mensaje");
                        //System.out.println("Ya ha enviado un mensaje");
                    }
                    break;

                case 2: //Ver Mensaje Enviado
                    if (!enviado) {
                        JOptionPane.showMessageDialog(null, "Primero debe enviar un mensaje");
                        //System.out.println("Primero debe enviar un mensaje");
                    } else {
                        JOptionPane.showMessageDialog(null, "MENSAJE: " + mensaje.getCadena());
                        //System.out.println("MENSAJE : " + mensaje.getCadena());
                    }
                    break;
                case 3: //Desencriptar Mensaje
                    if (enviado) {
                        //System.out.println("Ingrese la contraseña de encriptacion ");
                        //password = scanner.next();
                        password = JOptionPane.showInputDialog("Ingrese la contraseña de encriptacion");

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

                            JOptionPane.showMessageDialog(null, "MENSAJE: " + mensaje.getCadena());
                            enviado = false;
                        } else {
                            JOptionPane.showMessageDialog(null, "Contraseña Incorrecta");
                            //System.out.println("Contraseña Incorrecta");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Aun no se ha eniado ningun mensaje");
                        //System.out.println("Aun no se ha enviado ningun mensaje");
                    }
                    break;
                case 4: //Cambiar Contraseña
                    //System.out.println("Ingrese la contraseña actual");
                    //password = scanner.next();
                    password = JOptionPane.showInputDialog("Ingrese la contraseña actual");
                    if (password.equals(contraseña)) {
                        //System.out.println("Ingrese la nueva contraseña");
                        //contraseña = scanner.next();
                        contraseña = JOptionPane.showInputDialog("Ingrese la nueva contraseña");
                    } else {
                        JOptionPane.showMessageDialog(null, "Contraseña Incorrecta");
                        //System.out.println("Contraseña Incorrecta");
                    }
                    break;
                case 5: //Salir
                    JOptionPane.showMessageDialog(null, "Adios");
                    //System.out.println("Adios");
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");
                //System.out.println("Ingrese una opcion valida");

            }//Switch
        }//While
    }//Main

    /*
    //Menu Mostrado por consola
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
     */
}
