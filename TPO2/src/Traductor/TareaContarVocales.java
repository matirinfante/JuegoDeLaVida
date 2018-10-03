package Traductor;

import java.util.concurrent.RecursiveTask;

public class TareaContarVocales extends RecursiveTask<Integer> {

    private final char[] arreglo;
    private final int primerElem;
    private final int ultimoElem;

    //Cantidad de elementos por tarea
    private final int EPT = 25;

    //Constructor
    public TareaContarVocales(char[] set, int primer, int ultimo) {
        this.arreglo = set;
        this.primerElem = primer;
        this.ultimoElem = ultimo;
    }

    @Override
    protected Integer compute() {
        int contVocales = 0;
        if (this.ultimoElem - this.primerElem < this.EPT) {
            contVocales = contarVocales();
            System.out.println("Completado de " + this.primerElem + ", al: " + this.ultimoElem);
        } else {

            int mitad = (this.ultimoElem + this.primerElem) / 2;
            System.out.println("Tares pendientes: " + getQueuedTaskCount());
            TareaContarVocales subTarea1 = new TareaContarVocales(arreglo, this.primerElem, mitad + 1);
            TareaContarVocales subTarea2 = new TareaContarVocales(arreglo, mitad + 1, this.ultimoElem);
            subTarea1.fork();
            subTarea2.fork(); //Continua la ejecucion

            contVocales += subTarea1.join(); //Espera el resultado
            contVocales += subTarea2.join();
        }
        return contVocales;
    }

    private int contarVocales() {
        int contar = 0;

        for (int i = this.primerElem; i < this.ultimoElem; i++) {
            if (esVocal(arreglo[i])) {
                contar = ++contar;
            }
        }
        // System.out.println("VOCALES CONTADAS " +contar);
        return contar;
    }

    private boolean esVocal(char c) {
        c = Character.toUpperCase(c);
        boolean respuesta = (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
        //System.out.println("VALOR DE VERDAD = " + respuesta);
        return respuesta;
    }

}
