/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Traductor;

/**
 *
 * @author Matt
 */
public class Mensaje {

    private char[] caracteres;

    //Constructores
    public Mensaje(String cadena) {
        this.caracteres = cadena.toCharArray();
    }

    public Mensaje(char[] array) {
        this.caracteres = array;
    }

    //Observadores
    public char[] getCaracteres() {
        return this.caracteres;
    }

    public String getCadena() {
        return new String(this.caracteres);
    }

    
    public int longitud(){
        return this.caracteres.length;
    }
    
    public char getChar(int pos){
        return this.caracteres[pos];
    }
    
    //Modificadores
    public void setCadena(String s) {
        this.caracteres = s.toCharArray();
    }

    public void setCaracteres(char[] c) {
        this.caracteres = c;
    }
    
    public void setChar(char c, int pos){
        this.caracteres[pos] = c;
    }
    
    
    

    //Operaciones Propias
    public void remplazar(int inicio, int fin, char[] nuevo) {

            for (int i = inicio; i < fin; i++) {
                for (int j = 0; j < nuevo.length; j++) {
                    this.caracteres[i] = nuevo[j];
                }
            }
        }
    
    
}
