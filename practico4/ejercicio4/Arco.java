package practico4.ejercicio4;

public class Arco<T> {
    
    private int verticeOrigen;
    private int verticeDestino;
    private T etiqueta;

    public Arco(int verticeOrigen, int verticeDestino, T etiqueta) {
        this.verticeOrigen = verticeOrigen;
        this.verticeDestino = verticeDestino;
        this.etiqueta = etiqueta;
    }

    public int getVerticeOrigen() {
        return this.verticeOrigen;
    }

    public int getVerticeDestino() {
        return this.verticeDestino;
    }

    public T getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public boolean equals(Object obj) {
        try {
            Arco<T> temp = (Arco<T>) obj;
            return this.getVerticeOrigen() == temp.getVerticeOrigen() 
                && this.getVerticeDestino() == temp.getVerticeDestino();
        } catch (Exception e) {
            return false;
        }

    }

}
