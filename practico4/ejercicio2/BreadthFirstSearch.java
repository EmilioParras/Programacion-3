import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class BreadthFirstSearch<T> {
    
    Map<Integer, String> colores;
    LinkedList<Integer> fila;

    public void BFS(GrafoDirigido<T> grafo) {
        fila = new LinkedList<>();

        Iterator<Integer> vertices = grafo.obtenerVertices();
        while (vertices.hasNext()) {
            Integer v = vertices.next();
            colores.put(v, "Blanco");
        }

        vertices = grafo.obtenerVertices();
        while (vertices.hasNext()) {
            Integer v = vertices.next();
            if (colores.get(v) == "Blanco") {
                BFS(grafo, v);
            }
        }
    }

    public void BFS (GrafoDirigido<T> grafo, Integer vertice) {
        colores.put(vertice, "Amarillo");
        fila.add(vertice);
        
        while (!fila.isEmpty()) {
            Integer v = fila.remove();
            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(v);
            while (adyacentes.hasNext()) {
                Integer verticeSig = adyacentes.next();
                if (colores.get(verticeSig) == "Blanco") {
                    colores.put(verticeSig, "Amarillo");
                    fila.add(verticeSig);
                }
            }
        }
        
    }

}
