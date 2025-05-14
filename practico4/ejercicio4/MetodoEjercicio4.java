package practico4.ejercicio4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class MetodoEjercicio4<T> {
    
    private LinkedList<Integer> camino;
    private Map<Integer, String> colores;
    private int tamMayor = -1;

    public LinkedList<Integer> MetodoE4(GrafoDirigido<T> grafo, Integer origen, Integer destino) {
        camino = new LinkedList<>();
        colores = new HashMap<>();
        tamMayor = -1;
        
        // Recorro todos los vertices y los pongo como NO VISITADOS.
        Iterator<Integer> vertices = grafo.obtenerVertices(); 
        while (vertices.hasNext()) {
            Integer verticeAux = vertices.next();
            colores.put(verticeAux, "Blanco");
        }

        LinkedList<Integer> caminoActual = new LinkedList<>();
        caminoActual.add(origen);
        MetodoE4_Visit(grafo, origen, destino, caminoActual);

        return camino;
    }

    public void MetodoE4_Visit(GrafoDirigido grafo, Integer actual, Integer destino, LinkedList<Integer> caminoActual) {

        if (actual.equals(destino)) {
            if (caminoActual.size() > tamMayor) {
                tamMayor = caminoActual.size();
                camino = new LinkedList<>(caminoActual);
            }
            return;
        }

        colores.put(actual, "Amarillo");

        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(actual);
        while (adyacentes.hasNext()) {
            Integer siguiente = adyacentes.next();
            
            if (colores.get(siguiente) == "Blanco") {
                caminoActual.addLast(siguiente);
                MetodoE4_Visit(grafo, siguiente, destino, caminoActual);
                caminoActual.removeLast();
            }
        }

        colores.put(actual, "Blanco");

    }

}
