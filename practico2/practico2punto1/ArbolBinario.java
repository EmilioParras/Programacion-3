package practico2.practico2punto1;

import java.util.LinkedList;

public class ArbolBinario {
    
    private NodoBinario raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public void add(int valor) {
        if (isEmpty()) {
            this.raiz = new NodoBinario(valor);
        } else{
            add(this.raiz, valor);
        }
    }

    private void add(NodoBinario raiz, int valor) { // big-O: O(N)
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

    public int getRoot() { // big-O: O(1)
        return this.raiz.getValor();
    }

    public boolean hasElem(int elem) {
        if (!isEmpty()) {
            return hasElem(raiz, elem);
        } else {
            return false;
        }
    }

    private boolean hasElem(NodoBinario raiz ,int elem) { // big-O: O(N)
        if (raiz.getValor() != elem) {
            if (raiz.getValor() > elem) {
                if (raiz.getIzquierda() == null) {
                    return false;
                } else {
                    return hasElem(raiz.getIzquierda(), elem);
                }
            } else if (raiz.getValor() < elem) {
                if (raiz.getDerecha() == null) {
                    return false;
                } else {
                    return hasElem(raiz.getDerecha(), elem);
                }
            }
        }
        return true;
    }
    
    public int getHeight() {
        if (isEmpty() || (raiz.getIzquierda() == null && raiz.getIzquierda() == null)) {
            return 0;
        }
        return getHeight(raiz, 0);
    }

    private int getHeight(NodoBinario raiz, int valor) { // big-O: O(N)
        int valorD = valor;
        int valorI = valor;

        if (raiz.getDerecha() != null) {
            valorD++;
            valorD += getHeight(raiz.getDerecha(), valorD);
        }

        if (raiz.getIzquierda() != null) {
            valorI++;
            valorI += getHeight(raiz.getIzquierda(), valorI);
        }

        if (valorD > valorI) {
            return valorD;
        } else if (valorI > valorD) {
            return valorI;
        } else {
            return valorD;
        }
    }

    public void printPreOrder() {
        printPreOrder(this.raiz);
    }

    private void printPreOrder(NodoBinario nodo) {
        if (nodo == null) {
            System.out.println("-");  // Opcional: Representa un nodo nulo
            return;
        }
        System.out.println(nodo.getValor());  // Visita la raíz
        printPreOrder(nodo.getIzquierda());   // Recorre subárbol izquierdo
        printPreOrder(nodo.getDerecha());     // Recorre subárbol derecho
    }

    public void printInOrder() {
        printInOrder(this.raiz);
    }

    private void printInOrder(NodoBinario nodo) {
        if (nodo == null) {
            System.out.println("-"); 
            return;
        }
        printInOrder(nodo.getIzquierda());   
        System.out.println(nodo.getValor()); 
        printInOrder(nodo.getDerecha());     
    }

    public void printPostOrder() {
        printPostOrder(this.raiz);
    }

    private void printPostOrder(NodoBinario nodo) {
        if (nodo == null) {
            System.out.println("-");
        }
        printPostOrder(nodo.getIzquierda());
        printPostOrder(nodo.getDerecha());
        System.out.println(nodo.getValor());
    }

    public LinkedList<Integer> getLongestBranch() {  
        if (isEmpty()) {
            throw new IllegalStateException("Arbol vacio.");
        }
        return getLongestBranch(this.raiz);
    }

    private LinkedList<Integer> getLongestBranch(NodoBinario nodo) { // big-O O(N)
        if (nodo == null) {
            return new LinkedList<>(); 
        }
    
        // Obtener las ramas izquierda y derecha
        LinkedList<Integer> ramaIzquierda = getLongestBranch(nodo.getIzquierda());
        LinkedList<Integer> ramaDerecha = getLongestBranch(nodo.getDerecha());

        // Elegir la rama más larga
        LinkedList<Integer> ramaMasLarga;
        if (ramaIzquierda.size() > ramaDerecha.size()) {
            ramaMasLarga = ramaIzquierda;
        } else {
            ramaMasLarga = ramaDerecha;
        }
    
        // Agregar el valor del nodo actual al inicio de la rama
        ramaMasLarga.addFirst(nodo.getValor());
    
        return ramaMasLarga;
    }    

    private boolean esHoja(NodoBinario nodo) {
        return nodo.getIzquierda() == null && nodo.getDerecha() == null;
    }

    public void getFrontera() {
        getFrontera(this.raiz);
    }

    private void getFrontera(NodoBinario nodo) { // big-O O(N)
        if (nodo.getDerecha() == null && nodo.getIzquierda() == null) {
            System.out.println(nodo.getValor());
        }
        if (nodo.getIzquierda() != null) {
            getFrontera(nodo.getIzquierda());
        } 
        if (nodo.getDerecha() != null) {
            getFrontera(nodo.getDerecha());
        }
    }

    public int getMaxElem() {
        if (isEmpty()) {
            throw new IllegalStateException("Arbol vacio.");
        }
        return getMaxElem(this.raiz, 0);
    }

    private int getMaxElem (NodoBinario nodo, int val) { // big-O O(N)
        int max = val;
        if (nodo != null && nodo.getValor() > max) {
            max = nodo.getValor();
        }
        if (nodo.getIzquierda() != null) {
            max = getMaxElem(nodo.getIzquierda(), max);
        } 
        if (nodo.getDerecha() != null) {
            max = getMaxElem(nodo.getDerecha(), max);
        }
        return max;
    }

    public LinkedList<Integer> getElemAtLevel(int n) {
        return getElemAtLevel(this.raiz, n, 0);
    }

    private LinkedList<Integer> getElemAtLevel(NodoBinario nodo, int nivel, int nivelRaiz) { // big-O O(N)
        LinkedList<Integer> lista = new LinkedList<>();
        if (nodo == null) {
            return lista;
        }
        if (nivel == nivelRaiz) {
            lista.add(nodo.getValor()); //Si coinciden los niveles agrego el valor
        } else {
            //Recorro el arbol por derecha e izquierda hasta que el nodo sea nulo o hasta agregar un elemento cuando coincidan los niveles
            lista.addAll(getElemAtLevel(nodo.getIzquierda(), nivel, nivelRaiz + 1));
            lista.addAll(getElemAtLevel(nodo.getDerecha(), nivel, nivelRaiz + 1));
        }

        return lista;
    }

    public boolean delete(int numero) {
        if (isEmpty()) {
            return false;
        }
        raiz = delete(raiz, numero);
        return true;
    }

    private NodoBinario delete(NodoBinario nodo, int numero) {
        if (nodo == null) {
            return null;
        }

        if (nodo.getValor() > numero) {
            nodo.setIzquierda(delete(nodo.getIzquierda(), numero));
        } else if (nodo.getValor() < numero) {
            nodo.setDerecha(delete(nodo.getDerecha(), numero));
        } else {
            if (nodo.getIzquierda() == null) { // Caso para nodo hoja o con un solo hijo 
                return nodo.getDerecha();
            } else if (nodo.getDerecha() == null) {
                return nodo.getIzquierda();
            }
            // Caso para nodo con dos hijos
            nodo.setValor(minValue(nodo.getDerecha()));
            nodo.setDerecha(delete(nodo.getDerecha(), nodo.getValor()));
        }

        return nodo;
    }

    private int minValue(NodoBinario nodo) {
        int minv = nodo.getValor();
        while (nodo.getIzquierda() != null) {
            minv = nodo.getIzquierda().getValor();
            nodo = nodo.getIzquierda();
        }
        return minv;
    }    

    public int getSumaNodos() {
        if (isEmpty()) {
            return 0;
        }
        return getSumaNodos(this.raiz);
    }

    private int getSumaNodos(NodoBinario nodo) { // big-O O(N) Ejercicio 2
        int total = 0;
        if (nodo == null) {
            return total;
        }
        total += nodo.getValor();
        total += getSumaNodos(nodo.getIzquierda());
        total += getSumaNodos(nodo.getDerecha());
        return total;
    }

    public LinkedList<Integer> getHojasMayoresK (int k) { //big-O O(N) Ejercicio 3
        if (isEmpty()) {
            return new LinkedList<>();
        }
        return getHojasMayoresK(raiz, k);
    }

    private LinkedList<Integer> getHojasMayoresK(NodoBinario nodo, int k) {
        LinkedList<Integer> lista = new LinkedList<>();
        if (nodo == null) {
            return new LinkedList<>();
        }
        if (esHoja(nodo) && nodo.getValor() > k) {
            lista.add(nodo.getValor());
        }
        lista.addAll(getHojasMayoresK(nodo.getIzquierda(), k));
        lista.addAll(getHojasMayoresK(nodo.getDerecha(), k));

        return lista;
    }

    public void llenarNodosVacios() {
        if (isEmpty()) {
            throw new IllegalStateException("Arbol vacio.");
        }
        llenarNodosVacios(raiz);
    }

    private void llenarNodosVacios(NodoBinario nodo) {
        if (nodo == null) {
            return;
        }

        llenarNodosVacios(nodo.getIzquierda());
        llenarNodosVacios(nodo.getDerecha());

        if (nodo.getValor() == 0) {
            if (nodo.getIzquierda() != null && nodo.getDerecha() != null) {
                nodo.setValor(nodo.getDerecha().getValor() - nodo.getIzquierda().getValor());
            } else if (nodo.getIzquierda() == null && nodo.getDerecha() != null) {
                nodo.setValor(nodo.getDerecha().getValor() - 0);
            } else if (nodo.getDerecha() == null && nodo.getIzquierda() != null) {
                nodo.setValor(0 - nodo.getIzquierda().getValor());
            }
        }

    }

    /*public LinkedList<String> getPalabrasVocal(int N) { //Ejercicio 5. big-O O(N) Recorre todo el arbol.
        if (isEmpty()) {
            return new LinkedList<>();
        }
        LinkedList<String> resultado = new LinkedList<>();
        backTrackVocales(raiz,new StringBuilder(), 0, N, resultado);
        return resultado;
    }

    private void backTrackVocales(NodoBinario raiz, StringBuilder palabraActual, int contador, int N, LinkedList<String> resultado) {
        if (raiz == null) {
            return;
        }

        palabraActual.append(raiz.getValor()); //Agrego el valor de mi nodo actual.
        if (esVocal(raiz.getValor())) { 
            contador++;
        }

        if (esHoja(raiz)) { //Si es hoja, es decir que ya se recorrio la rama, y el contador es igual a N. Esa palabra cumplio y se agrega al resultado final.
            if (contador == N) {
                resultado.add(palabraActual.toString());
            }
        } else {
            backTrackVocales(raiz.getIzquierda(), palabraActual, contador, N, resultado);
            backTrackVocales(raiz.getDerecha(), palabraActual, contador, N, resultado);
        }       

        //Borro el ultima caracter para seguir recorriendo a partir de el caracter anterior
        palabraActual.deleteCharAt(palabraActual.length() -1);
    }

    public boolean esVocal(char c) {
        return ((c == 'A') || (c == 'E') || (c == 'I') || (c == 'O') || (c == 'U'));
    } */
}

