package practico1;

import java.util.Iterator;

public class IteradorLista2<T extends Comparable<T>> implements Iterator<T> {

    private NodoDoble<T> actual;

    public IteradorLista2 (NodoDoble<T> actual) {
        this.actual = actual;
    }

    @Override
    public boolean hasNext() {
        return actual != null;
    }

    @Override
    public T next() {
        T res = actual.getInfo();
        actual.getSiguiente();
        return res;
    }
    
}
