package practico4.ejercicio5;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import practico4.ejercicio4.GrafoDirigido;

public class MetodoEjercicio5<T> {
    
    private LinkedList<Integer> lista;
    private HashMap<Integer, String> colores;

    public LinkedList<Integer> ejercicio5(GrafoDirigido<T> grafo, Integer destino) {
        
        lista = new LinkedList<>();
        colores = new HashMap<>();

        Iterator<Integer> vertices = grafo.obtenerVertices();
        while (vertices.hasNext()) {
            Integer vAux = vertices.next();
            colores.put(vAux, "Blanco");
        }

        vertices = grafo.obtenerVertices();
        while (vertices.hasNext()) {
            Integer vAux = vertices.next();
            if (backtrack(grafo, vAux, destino)) {
                lista.add(vAux);
            }
        }

        return lista;
    }

    public boolean backtrack(GrafoDirigido grafo, Integer actual, Integer destino) {

        if (actual.equals(destino)) {
            return true;
        }

        colores.put(actual, "Amarillo");

        boolean encontrado = false;
        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(actual);
        while (adyacentes.hasNext() && !encontrado) {
            Integer siguiente = adyacentes.next();
            if (colores.get(siguiente) == "Blanco") {
                encontrado = backtrack(grafo, siguiente, destino);
            } 
        }

        colores.put(actual, "Blanco");
        return encontrado;
    }

}
