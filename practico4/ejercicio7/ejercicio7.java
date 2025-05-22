package practico4.ejercicio7;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import practico4.ejercicio4.GrafoDirigido;

public class ejercicio7<T> {
 
    private HashMap<Integer, String> colores;
    private List<List<Integer>> caminosPosibles; 

    public List<List<Integer>> ejercicio5_DFS(GrafoDirigido<T> grafo, Integer origen, Integer destino) {
        colores = new HashMap<>();
        caminosPosibles = new LinkedList<>();

        //Pongo todos los vertices en blanco.
        colores.put(origen, "Blanco");
        Iterator<Integer> vertices = grafo.obtenerVertices();
        while (vertices.hasNext()) {
            Integer vertice = vertices.next();
            colores.put(vertice, "Blanco");
        }

        LinkedList<Integer> caminoActual = new LinkedList<>();
        caminoActual.add(origen);
        DFS(grafo, origen, destino, caminoActual);

        return caminosPosibles;
    }

    public void DFS (GrafoDirigido<T> grafo, Integer actual, Integer destino, LinkedList<Integer> caminoActual) {

        if (actual.equals(destino)) {
            caminosPosibles.add(new LinkedList<>(caminoActual));
            return;
        }

        colores.put(actual, "Amarillo");

        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(actual);
        while (adyacentes.hasNext()) {
            Integer adyacente = adyacentes.next();
            if (colores.get(adyacente).equals("Blanco")) {
                caminoActual.addLast(adyacente);
                DFS(grafo, adyacente, destino, caminoActual);
                caminoActual.removeLast();
                //colores.put(actual, "Blanco"); 
            }
        }
        colores.put(actual, "Blanco");
    }

}
