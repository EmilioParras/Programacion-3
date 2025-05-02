package carpetaDePruebas;

import java.util.LinkedList;

public class ArbolBinario {
    
    private NodoBinario raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public void add(char valor) {
        if (isEmpty()) {
            this.raiz = new NodoBinario(valor);
        } else{
            add(this.raiz, valor);
        }
    }

    private void add(NodoBinario raiz, char valor) { // big-O: O(N)
        if (raiz.getValor() > valor) {
            if (raiz.getIzquierda() == null) {
                NodoBinario nuevo = new NodoBinario(valor);
                raiz.setIzquierda(nuevo);
            } else {
                add(raiz.getIzquierda(), valor);
            }
        } else if (raiz.getValor() < valor) {
            if (raiz.getDerecha() == null) {
                NodoBinario nuevo = new NodoBinario(valor);
                raiz.setDerecha(nuevo);
            } else {
                add(raiz.getDerecha(), valor);
            }
        }
    }

    public boolean isEmpty() { // big-O: O(1)
        return this.raiz == null;
    }
    
    public void printPreOrder() {
        if (isEmpty()) {
            return;
        }
        printPreOrder(this.raiz);
    }

    private void printPreOrder(NodoBinario nodo) {
        if (nodo == null) {
            System.out.println("-");
            return;
        }
        System.out.println(nodo.getValor());
        printPreOrder(nodo.getIzquierda());
        printPreOrder(nodo.getDerecha());
    }

    public boolean esUnaHoja(NodoBinario raiz) {
        return ((raiz.getIzquierda() == null) && (raiz.getDerecha() == null));
    }

    public LinkedList<String> getPalabrasVocal(int N) {
        if (isEmpty()) {
            return new LinkedList<>();
        }
        LinkedList<String> resultado = new LinkedList<>();
        backTrack(raiz, new StringBuilder(), 0, N, resultado);
        return resultado;
    }

    private void backTrack(NodoBinario raiz, StringBuilder palabraActual, int contador, int N, LinkedList<String> resultado) {
        if (raiz == null) {
            return;
        }

        palabraActual.append(raiz.getValor()); //Agrego el valor de mi nodo actual.
        if (esVocal(raiz.getValor())) { 
            contador++;
        }

        if (esUnaHoja(raiz)) { //Si es hoja, es decir que ya se recorrio la rama, y el contador es igual a N. Esa palabra cumplio y se agrega al resultado final.
            if (contador == N) {
                resultado.add(palabraActual.toString());
            }
        } else {
            backTrack(raiz.getIzquierda(), palabraActual, contador, N, resultado);
            backTrack(raiz.getDerecha(), palabraActual, contador, N, resultado);
        }       

        //Borro el ultima caracter para seguir recorriendo a partir de el caracter anterior
        palabraActual.deleteCharAt(palabraActual.length() -1);
    }

    public boolean esVocal(char c) {
        return ((c == 'A') || (c == 'E') || (c == 'I') || (c == 'O') || (c == 'U'));
    }
}

