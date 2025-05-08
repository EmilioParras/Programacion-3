import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class GrafoDirigidoSet<T> implements Grafo<T> {
    
	private Map<Integer, Set<Arco<T>>> listaAdyacencia; // Lista de adyacencia para un Grafo Dirigido.
														//Integer es el valor del vertice. listaAdyacencia es un HashMap con los vertices adyacentes

	public GrafoDirigidoSet() {
		//El grafo se crea vacio. Crece dinamicamente a medida que le agrego vertices y arcos.
		this.listaAdyacencia = new HashMap<>();
	}

	@Override
	public void agregarVertice(int verticeId) {
		listaAdyacencia.putIfAbsent(verticeId, new HashSet<>());
	}

	@Override
	public void borrarVertice(int verticeId) {
		//Borrar tanto de los vertices de los que es adyacente como de sus vertices adyyacentes.

	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		if (contieneVertice(verticeId1) && contieneVertice(verticeId2)) {
			Arco<T> nuevoArco = new Arco<>(verticeId1, verticeId2, etiqueta);
			listaAdyacencia.get(verticeId1).add(nuevoArco);
		} else {
			System.out.println("Vertice " + verticeId1 + " o " + verticeId2 + " no existen.");
		}
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		if (!contieneVertice(verticeId1)) {
			return;
		}
		Set<Arco<T>> arcos = listaAdyacencia.get(verticeId1);
		arcos.removeIf(a -> a.getVerticeDestino() == verticeId2);
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		return listaAdyacencia.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		if (!contieneVertice(verticeId1)) {
			return false;
		} 
		boolean res = false;
		Set<Arco<T>> arcos = listaAdyacencia.get(verticeId1);
		for (Arco<T> a : arcos) {
			if (a.getVerticeDestino() == verticeId2) {
				res = true;
			}
		} 
		return true;

		//return listaAdyacencia.get(verticeId1).stream()
		//.anyMatch(arco -> arco.getVerticeDestino() == verticeId2);
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		if (listaAdyacencia.containsKey(verticeId1)) {
			if (existeArco(verticeId1, verticeId2)) {
				return new Arco(verticeId1, verticeId2, 1);
			}
		}	
		return null;
	}

	@Override
	public int cantidadVertices() {
		return listaAdyacencia.size();
	}

	@Override
	public int cantidadArcos() {
		int total = 0;
		Iterator<Integer> vertices = obtenerVertices();
		while (vertices.hasNext()) {
			
		}
		return total;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		//return listaAdyacencia.keySet().iterator();
		Set<Integer> vertices = listaAdyacencia.keySet();
		return vertices.iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		// TODO Auto-generated method stub
		return null;
	}
    
}
