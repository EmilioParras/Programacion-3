
public class Main {
    
    public static void main(String[] args) {
    
        GrafoDirigido<Integer> grafo = new GrafoDirigido<>();
        
        //Agregar vertice. Si el valor (verticeId) ya existe no lo agrega.
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);

        //Borrar vertice.
        grafo.borrarVertice(4);

        //Agregar arco.
        grafo.agregarArco(1, 2, 15);

        //Boorar
    }
}
