package practico1;
import java.util.Iterator;

public class LinkedList<T extends Comparable<T>> implements Iterable<T> {

    private Node<T> nodo;
    private int size;

    public LinkedList() {
        this.nodo = null;
        this.size = 0;
    }

    public void insertFront(T info) {
        Node<T> nuevo = new Node<>(info, null);
        nuevo.setNext(nodo);
        this.nodo = nuevo;
        this.size++;
    }
    
	public T extractFront() {		
		T aux = this.nodo.getInfo();
        nodo = nodo.getNext();
        this.size--;
        return aux;
	}

	public boolean isEmpty() {
		return nodo == null;
	}
	
	public T get(int index) {
        int i = 0;
        T res = nodo.getInfo();
        if (index >= 0 && index <= this.getSize()) {
            while (i != index && i < index && index <= this.getSize()) {
                nodo = nodo.getNext();
            }
            res = nodo.getInfo();
            return res;
        }
        return null;
	}
	
	public int getSize() {
		return this.size;
	}
	
	@Override
	public String toString() {
        Node<T> aux = nodo;
        String res = " ";
        while (aux != null) {
            res += "|" + (aux.getInfo());
            aux = aux.getNext();
        }
        return res;
	}

    public int indexOf(T elem) {
        int i = 0;
        Node<T> nAux = nodo;

        if (elem == null || isEmpty()) {
            return -1;
        }     

        while (nAux != null) {
            if (nAux.getInfo().equals(elem)) {
                return i;
            }
            nAux = nAux.getNext();
            i++;
        }
        return -1;
    }

    public void insertarOrdenado(T elem) {
        Node<T> newN = new Node<>(elem,null);
        
        // Pregunto si la lista esta vacia o si la primer posicion es mayor que lo que quiero insetar
        if (isEmpty() || nodo.getInfo().compareTo(newN.getInfo()) > 0) {
            insertFront(elem);
            return;
        }

        // Creo un nodo que apunte al primer nodo de la lista
        Node<T> nodoAux = nodo;

        // Mientras que el nodo siguiente no sea nulo y sea menor que el que quiero insertar
        // el nodo aux va a apuntar a el siguiente
        while (nodoAux.getNext() != null && nodoAux.getNext().getInfo().compareTo(newN.getInfo()) <= 0) {
            nodoAux = nodoAux.getNext();
        }

        // Cuando sale del while. El nodoAux esta apuntando o a un null o a un elemento mayor al que queremos insertar
        // Entonces el nodo que queremos insertar va a apuntar a ese nodo porque es mayor o porque esnull.
        // Y el nodo aux va a apuntar a el nodo que queremos insertar
        newN.setNext(nodoAux.getNext()); // Si estoy parado sobre un null, y uso getNext apunta a otro null?
        nodoAux.setNext(newN);
        this.size++;
    }


    @Override
    public Iterator<T> iterator() {
        return new IteradorLista<T>(this.nodo);
    }

}

