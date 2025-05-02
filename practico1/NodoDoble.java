package practico1;

public class NodoDoble<T extends Comparable<T>>{
    
    private NodoDoble<T> anterior;
    private NodoDoble<T> siguiente;
    private T info;

    public NodoDoble (NodoDoble<T> anterior, NodoDoble<T> siguiente,T info) {
        this.siguiente = anterior;
        this.anterior = siguiente;
        this.info = info;
    }

    public NodoDoble<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble<T> anterior) {
        this.anterior = anterior;
    }

    public NodoDoble<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble<T> siguiente) {
        this.siguiente = siguiente;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }
    
}
