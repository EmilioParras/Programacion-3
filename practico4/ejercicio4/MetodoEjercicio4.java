package practico4.ejercicio4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class MetodoEjercicio4<T> {
    
    private LinkedList<Integer> camino;
    private Map<Integer, String> colores;

    public void MetodoE4(GrafoDirigido<T> grafo, Integer verticeI, Integer verticeJ) {

        camino = new LinkedList<>();
        int tam = 0;
        int tamMayor = 0;
        
        Iterator<Integer> vertices = grafo.obtenerVertices(); // Recorro todos los vertices y los pongo en blanco.
        while (vertices.hasNext()) {
            Integer verticeAux = vertices.next();
            colores.put(verticeAux, "Blanco");
        }

            if (colores.get(verticeI) == "Blanco") {
                tam = MetodoE4_Visit(grafo, verticeI, verticeJ);
            }

        if (tam > tamMayor) {
            tamMayor = tam;
        }

        System.out.println("El camino mas largo es de " + tamMayor);
    }


    public int MetodoE4_Visit (GrafoDirigido grafo, Integer verticeI, Integer verticeJ) {
        int tam = 0;
        colores.put(verticeI, "Amarillo");
        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(verticeI);
        while (adyacentes.hasNext()) {
            Integer verticeAux = adyacentes.next();
            tam++;
            if () {
                
            }
        }


        return tam;
    }
}
