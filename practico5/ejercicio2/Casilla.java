package ejercicio2;

public class Casilla {
    
    private Casilla norte;
    private Casilla sur;
    private Casilla este;
    private Casilla oeste;
    private boolean visitado;
    private int valorPos;

    public Casilla(Casilla norte, Casilla sur, Casilla este, Casilla oeste, int valorPos) {
        this.norte = norte;
        this.sur = sur;
        this.este = este;
        this.oeste = oeste;
        this.visitado = false;
        this.valorPos = valorPos;
    }

    public Casilla getCasillaNorte() {
        return norte;
    }

    public Casilla getCasillaSur() {
        return sur;
    }

    public Casilla getCasillaEste() {
        return este;
    }

    public Casilla getCasillaOeste() {
        return oeste;
    }

    public int getValorPos() {
        return valorPos;
    }

    public boolean visitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    

    

}
