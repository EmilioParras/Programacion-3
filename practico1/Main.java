package practico1;

public class Main {
    
    public static <T> void main(String[] args) {
        
        LinkedList<Integer> lista = new LinkedList<Integer>();
        lista.insertFront(3);
        lista.insertFront(5);
        lista.insertFront(7);
        lista.insertFront(8);
        lista.insertFront(1);
        lista.insertFront(2);
        lista.insertFront(4);
        lista.insertFront(4);

        LinkedList<Integer> lista2 = new LinkedList<Integer>();
        lista2.insertFront(3);
        lista2.insertFront(1);
        lista2.insertFront(8);
        lista2.insertFront(12);
        lista2.insertFront(7);
        lista2.insertFront(5);


        //LinkedList<Integer> listaPunto5 = listaEnComun(lista, lista2);
        //for (int elemento : listaPunto5) {
        //    System.out.println(elemento);
        //}

        LinkedList<Integer> listaPunto6 = listaPuntoSeis(lista, lista2);
        for (int elemento : listaPunto6) {
            System.out.println(elemento);
        }

    }        
    
    //Punto 5
    public static LinkedList<Integer> listaEnComun(LinkedList<Integer> lista, LinkedList<Integer> lista2) {
        LinkedList<Integer> res = new LinkedList<>();
        for (Integer elem : lista) {
            for (Integer elem2 : lista2) {
                if (elem.equals(elem2)) {
                    // Verificar si el elemento ya está en la lista resultante
                    if (res.indexOf(elem) == -1) { // Si no está, agregarlo
                        res.insertarOrdenado(elem); 
                    }
                }
            }
        }
        return res;
    }

    //Punto 6
    public static LinkedList<Integer> listaPuntoSeis(LinkedList<Integer> lista1, LinkedList<Integer> lista2) {
        LinkedList<Integer> res = new LinkedList<>();
        for (Integer elem1 : lista1) {
                if (lista2.indexOf(elem1) == -1) {
                    res.insertarOrdenado(elem1);
            }
        }
        return res;
    }
   

}