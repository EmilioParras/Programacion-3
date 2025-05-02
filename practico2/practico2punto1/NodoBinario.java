package practico2.practico2punto1;

public class NodoBinario {
    
    private int valor;
    private NodoBinario izquierda;
    private NodoBinario derecha;

    public NodoBinario(int valor) {
        this.valor = valor;
        this.izquierda = null;
        this.derecha = null;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
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

    //getRoot() DEVUELVE EL VALOR DE LA RAIZ
    //hasElem() basicamente un contains. Le paso un valor devuelve si tiene o no ese valor
    //isEmpty() devuelve si esta vacio
    //getHeight() me devuelve la altura del arbol. Cantidad de arcos hasta la hoja mas lejana. SI tiene un solo nodo o cero nodos altura 0
    //printPreOrder() imprimir con -
    //getLongestBranch() devuelve la lista de valores de la rama mas larga EN ORDEN DESDE LA RAIZ DICE GOROSITO
    //getFrontera() de izquierda a derecha todos los valores de las hojas
    //getMaxElem() devuelve el elemento mas grande
    // getElemAtLevel derecha al fondo imprimo ese valor
    // delete() le paso un valor y me devuelve verdadero si lo borro o no. Para el final
}
