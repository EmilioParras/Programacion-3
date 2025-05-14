import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import practico4.ejercicio4.GrafoDirigido;

public class DepthFirstSearch<T> {
    
    private Map<Integer, String> colores;
    private Map<Integer, Integer> descubrimiento;
    private Map<Integer, Integer> finalizacion;
    private int tiempo;

    public void DFS(GrafoDirigido<T> grafo) {
        colores = new HashMap<>();
        descubrimiento = new HashMap<>();
        finalizacion = new HashMap<>();
        tiempo = 0;

        Iterator<Integer> vertices = grafo.obtenerVertices();
        while (vertices.hasNext()) {
            Integer v = vertices.next();
            colores.put(v, "Blanco");
        }
        
        vertices = grafo.obtenerVertices();
        while (vertices.hasNext()) {
            Integer v = vertices.next();
            if (colores.get(v).equals("Blanco")) {
                DFS_Visit(grafo, v);
            }
        }
    }

    public void DFS_Visit(GrafoDirigido<T> grafo, Integer vertice) {
        colores.put(vertice, "Amarillo");
        tiempo++;
        descubrimiento.put(vertice, tiempo);

        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(vertice);
        while (adyacentes.hasNext()) {
            Integer v = adyacentes.next();
            if (colores.get(v).equals("Blanco")) {
                DFS_Visit(grafo, v);
            } else if(colores.get(v).equals("Amarillo")) {
                System.out.println("Hay ciclo");
            }
        }

        colores.put(vertice, "Negro");
        tiempo++;
        finalizacion.put(vertice, tiempo);
    }

}
