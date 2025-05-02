package carpetaDePruebas;

import java.util.LinkedList;

public class Main {
    
    public static void main(String[] args) {
        
        ArbolBinario arbol = new ArbolBinario();

        arbol.add('M');
        arbol.add('I');
        arbol.add('A');
        arbol.add('L');
        arbol.add('O');
        arbol.add('N');
        arbol.add('U');
        arbol.add('E');

        LinkedList<String> palabrasConVocales = arbol.getPalabrasVocal(1);
        for(String s : palabrasConVocales) {
            System.out.println(s);
        }

    }

}
