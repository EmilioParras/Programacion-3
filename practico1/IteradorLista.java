package practico1;

import java.util.Iterator;

public class IteradorLista<T extends Comparable<T>> implements Iterator<T>{

    private Node<T> actual;

    public IteradorLista(Node<T> acutal) {
        this.actual = acutal;
    }

    @Override
    public boolean hasNext() {  
        return actual != null;
    }

    @Override
    public T next() {
        T res = actual.getInfo();
        actual = actual.getNext();
        return res;
    }
    
}
