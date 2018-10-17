package JuegoDeLaVida;

public class Celula {

    private int nroCelula;
    private boolean estado;
    private boolean debeCambiar;

    public Celula(int nroCelula, boolean estado) {
        this.nroCelula = nroCelula;
        this.estado = estado;
        this.debeCambiar = false;
    }

    public int getNroCelula() {
        return nroCelula;
    }

    public void setNroCelula(int nroCelula) {
        this.nroCelula = nroCelula;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void debeCambiar() {
        this.debeCambiar = true;
    }
    
    public void cambio(){
        this.debeCambiar = false;
    }
    public boolean getdebeCambiar() {
        return this.debeCambiar;
    }

}
