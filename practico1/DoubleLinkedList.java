package practico1;

import java.util.Iterator;

public class DoubleLinkedList<T extends Comparable<T>> implements Iterable<T>{
    
    private NodoDoble<T> nodo;
    private int size;

    public DoubleLinkedList() {
        this.nodo = null;
        this.size = 0;
    }

    public DoubleLinkedList(NodoDoble<T> nodo) {
        this.nodo = nodo;
        this.size = 0;
    }

    public void insertFront(T info) {
        NodoDoble<T> newN = new NodoDoble<T>(null, nodo, info);
        nodo.setAnterior(newN);
        this.nodo = newN;
        this.size++;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteradorLista2<T>(nodo);    
    }

    public NodoDoble<T> getNodo() {
        return nodo;
    }

    public int getSize() {
        return size;
    }

    public T get(int index) {
        if (index < 0 || index >= this.getSize()) {
            return null;
        } 

        int i = 0;
        NodoDoble<T> actual = nodo;
        while (i < index && actual != null) {
            actual = actual.getSiguiente();
            i++;
        }
        if (actual != null) {
            return actual.getInfo();
        } else {
            return null;
        }
    }

    public T extractFront() {
        T aux = this.nodo.getInfo();
        nodo = nodo.getSiguiente();
        this.size--;
        return aux;
    }

    public boolean isEmpty() {
        return nodo == null;
    }

    public String toString() {
        NodoDoble<T> aux = this.nodo;
        String res = " ";
        while (aux != null) {
            res += "|" + (aux.getInfo());
            aux = aux.getSiguiente();
        }
        return res;
    }

}
