package practico2.practico2punto1;

public class Main {
    
    public static void main(String[] args) {
        
        ArbolBinario arbol = new ArbolBinario();

        arbol.add(8);
        arbol.add(5);
        arbol.add(3);
        arbol.add(10);
        arbol.add(7);
        arbol.add(11);
        arbol.add(6);
        arbol.add(12);

        System.out.println(arbol.delete(10));

    }

}
