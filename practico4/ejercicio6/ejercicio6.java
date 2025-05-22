import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ejercicio6<T> {
    
    HashMap<Integer, String> colores;
    HashMap<Integer, Integer> caminoFinal;
    ArrayList<Integer> fila;

    public void ejercicio6_BFS(GrafoDirigido<T> grafo, Integer origen, Integer destino) {
        colores = new HashMap<>();
        caminoFinal = new HashMap<>();

        Iterator<Integer> vertices = grafo.obtenerVertices();
        while (vertices.hasNext()) {
            Integer vertice = vertices.next();
            colores.put(vertice, "Blanco");
        }

        BFS(grafo, origen, destino);
        //Recorrer el HashMap de caminoFinal y armar el arraylist con el camino.
    }


    public void BFS (GrafoDirigido<T> grafo, Integer actual, Integer destino) {

        colores.put(actual, "Amarillo");
        fila.add(actual);
        boolean encontrado = false;

        while (!fila.isEmpty() && !encontrado) {
            Integer v = fila.remove(0);
            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(v);
            while (adyacentes.hasNext()) {
                Integer siguiente = adyacentes.next();
                caminoFinal.put(siguiente, v);
                if (siguiente.equals(destino)) {
                    encontrado = true;
                } else if (colores.get(siguiente) == "Blanco") {
                    colores.put(siguiente, "Amarillo");
                    fila.add(siguiente);
                }
            }
        }
    }

}
