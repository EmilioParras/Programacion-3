package ejercicio1;

import java.util.LinkedList;

public class HashingSeparadoCrecimiento {
    
    private int M = 7;
    private final double PD = 0.9;
    private int elementos;
    private LinkedList<Integer>[] tabla;

    public HashingSeparadoCrecimiento() {
        tabla = new LinkedList[M];
        elementos = 0;
        for (int i = 0; i < M; i++) {
            tabla[i] = new LinkedList();
        }
    }

    public int hash(int valor) {
        return valor % M;
    }

    public void insertar(int valor) {
        if ((double)elementos / M > PD) {
            redimensionar();
        }

        int pos = hash(valor);
        tabla[pos].add(valor);
        elementos++;
    }

    public void redimensionar() {
        int nuevoM = M * 2;
        LinkedList<Integer>[] nuevaTabla = new LinkedList[nuevoM];

        for (int i = 0; i < nuevoM; i++) {
            nuevaTabla[i] = new LinkedList<>();
        }

        int viejoM = this.M;
        this.M = nuevoM;

        for (int i = 0; i < viejoM; i++) {
            for (int valor : tabla[i]) {
                int rePos = hash(valor);
                nuevaTabla[rePos].add(valor);
            }
        }

        this.tabla = nuevaTabla;
    }

    public void mostrar() {
        System.out.println("Tabla hash (M=" + M + ", elementos=" + elementos + ")");
        for (int i = 0; i < M; i++) {
            System.out.print(i + " -> [");
            for (int j = 0; j < tabla[i].size(); j++) {
                System.out.print(tabla[i].get(j));
                if (j < tabla[i].size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }

}
