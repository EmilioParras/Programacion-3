package ejercicio1;
import java.util.LinkedList;

public class HashingSeparado {
    
    private final int M;
    private LinkedList<Integer>[] tabla;

    public HashingSeparado(int M, int RP,int RS) {
        this.M = M;
        tabla = new LinkedList[M];
        for (int i = 0; i < M-1; i++) {
            tabla[i] = new LinkedList<>();
        }
    }

    public HashingSeparado() {
        this.M = 7;
        tabla = new LinkedList[M];
        for (int i = 0; i < M; i++) {
            tabla[i] = new LinkedList<>();
        }
    }

    public int hash(int valor) {
        return valor % M;
    }

    public void insertar(int valor) {
        int pos = hash(valor);
        tabla[pos].add(valor);
    }

    public void mostrar() {
        for (int i = 0; i < M; i++) {  // Mostrar TODAS las posiciones
            System.out.print(i + " -> [");
            for (int j = 0; j < tabla[i].size(); j++) {
                System.out.print(tabla[i].get(j));
                if (j < tabla[i].size() - 1) { 
                    System.out.print(", ");
                }
            }
            System.out.println("]");  // Salto de línea después de cada bucket
        }
    }
}
