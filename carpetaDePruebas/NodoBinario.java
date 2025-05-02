package carpetaDePruebas;

public class NodoBinario {
    
    private char valor;
    private NodoBinario izquierda;
    private NodoBinario derecha;

    public NodoBinario(char valor) {
        this.valor = valor;
        this.izquierda = null;
        this.derecha = null;
    }

    public void setValor(char valor) {
        this.valor = valor;
    }

    public NodoBinario getIzquierda() {
       return izquierda;
    }

    public void setIzquierda(NodoBinario izquierda) {
        this.izquierda = izquierda;
    }

    public NodoBinario getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoBinario derecha) {
        this.derecha = derecha;
    }

    public char getValor() {
        return valor;
    }

}
