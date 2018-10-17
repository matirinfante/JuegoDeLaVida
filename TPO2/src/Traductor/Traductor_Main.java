package Traductor;

import java.util.concurrent.*;
import javax.swing.JOptionPane;

public class Traductor_Main {

    public static void main(String[] args) {

        //Declaracion de Variables
        Mensaje mensaje = new Mensaje();
        String contraseña = "1234"; //Contraseña por defecto
        String password, cadena;
        int opcion;
        boolean salir = false;
        boolean enviado = false;

        //MENU
        while (!salir) {
            String op = JOptionPane.showInputDialog("Seleccione a una opcion\n1- Enviar Mensaje\n2- Ver Mensaje\n3- Desencriptar Mensaje\n4- Cambiar Contraseña\n5- Salir");
            opcion = Integer.parseInt(op);
            switch (opcion) {
                case 1: //Enviar Mensaje
                    if (!enviado) {
                        cadena = JOptionPane.showInputDialog("Ingrese el mensaje que desea enviar");
                        mensaje = new Mensaje(cadena);
                        password = JOptionPane.showInputDialog("Ingrese la contraseña de encriptacion ");
                        if (password.equals(contraseña)) {

                            Traductor tarea = new Traductor(mensaje, 0, mensaje.longitud());
                            ForkJoinPool pool = new ForkJoinPool();
                            pool.execute(tarea);
                            do {
                                try {
                                    TimeUnit.MILLISECONDS.sleep(5);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            } while (!tarea.isDone());
                            pool.shutdown();

                            JOptionPane.showMessageDialog(null, "Mensaje Enviado: " + mensaje.getCadena());
                            enviado = true;
                        } else {

                            JOptionPane.showMessageDialog(null, "Contraseña Incorrecta");
                            mensaje.setCadena("");
                        }//if else

                    } else {
                        JOptionPane.showMessageDialog(null, "Ya ha enviado un mensaje");

                    }
                    break;

                case 2: //Ver Mensaje Enviado
                    if (!enviado) {
                        JOptionPane.showMessageDialog(null, "Primero debe enviar un mensaje");

                    } else {
                        JOptionPane.showMessageDialog(null, "MENSAJE: " + mensaje.getCadena());
                    }
                    break;
                case 3: //Desencriptar Mensaje
                    if (enviado) {
                        password = JOptionPane.showInputDialog("Ingrese la contraseña de encriptacion");

                        if (password.equals(contraseña)) {

                            Traductor tarea = new Traductor(mensaje, 0, mensaje.longitud());
                            ForkJoinPool pool = new ForkJoinPool();
                            pool.execute(tarea);
                            do {
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
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Aun no se ha eniado ningun mensaje");
                    }
                    break;
                case 4: //Cambiar Contraseña
                    password = JOptionPane.showInputDialog("Ingrese la contraseña actual");
                    if (password.equals(contraseña)) {
                        contraseña = JOptionPane.showInputDialog("Ingrese la nueva contraseña");
                    } else {
                        JOptionPane.showMessageDialog(null, "Contraseña Incorrecta");
                    }
                    break;
                case 5: //Salir
                    JOptionPane.showMessageDialog(null, "Adios");
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");

            }//Switch

        }//While

    }//Main

}
