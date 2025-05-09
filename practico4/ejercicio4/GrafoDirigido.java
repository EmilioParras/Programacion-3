package practico4.ejercicio4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class GrafoDirigido<T> implements Grafo<T> {
    
	private Map<Integer, LinkedList<Arco<T>>> vertices = new HashMap<>(); // Lista de adyacencia para un Grafo Dirigido.
															//Integer es el valor del vertice. listaAdyacencia es un HashMap con los vertices adyacentes

	public GrafoDirigido() {
		//El grafo se crea vacio. Crece dinamicamente a medida que le agrego vertices y arcos.
	}

	@Override
	public void agregarVertice(int verticeId) {
		vertices.putIfAbsent(verticeId, new LinkedList<>());
	}

	@Override
	public void borrarVertice(int verticeId) {
		if (contieneVertice(verticeId)) {
			vertices.remove(verticeId);
		}
		
		//Recorro las LinkedList de mis vertices. 
		//Recorre los arcos de mis LinkedList.
		//Si los arcos de las LinedList tienen el verticeId como destino borro el ARCO de la LinkedList.
		for (LinkedList<Arco<T>> arcos : vertices.values()) {
				for (Arco a : arcos) {
					if (a.getVerticeDestino() == verticeId) {
						arcos.remove(a);
					}
				}
		}
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		Arco<T> nuevoArco = new Arco<T>(verticeId1, verticeId2, etiqueta);
		if (contieneVertice(verticeId1) && contieneVertice(verticeId2)) {
			LinkedList<Arco<T>> arcos = vertices.get(verticeId1); //Hashea y me devuelve la LinkedList de arcos.
			if (!arcos.contains(nuevoArco)) {
				arcos.add(nuevoArco);
			}
		}
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		if (!contieneVertice(verticeId1)) {
			return;
		}
		Arco<T> arcoBorrar = new Arco<T>(verticeId1, verticeId2, null);
		LinkedList<Arco<T>> arcos = vertices.get(verticeId1);
		arcos.remove(arcoBorrar); 
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		return vertices.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) { 
		return obtenerArco(verticeId1, verticeId2) != null;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		if (!contieneVertice(verticeId1)) {
			return null;
		}
		Arco<T> arcoB = new Arco<T>(verticeId1, verticeId2, null);
		LinkedList<Arco<T>> arcos = vertices.get(verticeId1);
		for(Arco a : arcos) {
			if (a.equals(arcoB)) {
				return a;
			}
		}
		return null;
	}

	@Override
	public int cantidadVertices() {	
		return vertices.size();
	}

	@Override
	public int cantidadArcos() {
		int total = 0;
		for (LinkedList<Arco<T>> arcos : vertices.values()) {
			total += arcos.size();
		}
		return total;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		return vertices.keySet().iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		LinkedList<Integer> adyacentes = new LinkedList<>();
		if (contieneVertice(verticeId)) {
			for (Arco<T> arco : vertices.get(verticeId)) {
				adyacentes.add(arco.getVerticeDestino());
			}
		}
		return adyacentes.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		LinkedList<Arco<T>> todosLosArcos = new LinkedList<>();
		for (LinkedList<Arco<T>> arcos : vertices.values()) {
			todosLosArcos.addAll(arcos);
		}
		return todosLosArcos.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		LinkedList<Arco<T>> arcos = new LinkedList<>();
		if (!contieneVertice(verticeId)) {
			return arcos.iterator();
		}
		arcos.addAll(vertices.get(verticeId));
		return arcos.iterator();
	}

}
