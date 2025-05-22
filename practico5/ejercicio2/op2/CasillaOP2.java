package ejercicio2;

public class CasillaOP2 {
    
    private Boolean norte;
    private Boolean sur;
    private Boolean este;
    private Boolean oeste;
    private Boolean visitado;
    private int valorPos;

    public CasillaOP2(Boolean norte, Boolean sur, Boolean este, Boolean oeste, int valorPos) {
        this.norte = norte;
        this.sur = sur;
        this.este = este;
        this.oeste = oeste;
        this.visitado = false;
        this.valorPos = valorPos;
    }

    public Boolean getNorte() {
        return norte;
    }

    public Boolean getSur() {
        return sur;
    }

    public Boolean getEste() {
        return este;
    }

    public Boolean getOeste() {
        return oeste;
    }

    public Boolean getVisitado() {
        return visitado;
    }

    public void setVisitado(Boolean visitado) {
        this.visitado = visitado;
    }

    public int getValorPos() {
        return valorPos;
    }

    

}
