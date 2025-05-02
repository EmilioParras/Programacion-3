package practico2;

public class Main {
    
    public static void main(String[] args) {

        int [] arr = new int[]{1,2,3,4,5,6,7,8};
        int [] arrDesordenado = new int[]{1,47,8,65,3,4,64};

        /*Ejercicio 1. Verificar si el arr esta ordenado
        boolean ordenado = estaOrdenado(arr);
        System.out.println(ordenado);*/

        /*Ejercicio 2. Buscar un elemento en un arr ordenado.
        int pos = buscar(arr, 5);
        if (pos >= 0) {
            System.out.println("Encontrado en la posicion " + pos);
        } else {
            System.out.println("No se encontro.");
        }*/

        /*Ejercicio 3. Algoritmo que convierta un numero en notacion deciamal a su equivalente en binaria.
        convertir(26);*/

        /*Ejercicio 4. Secuencia fibonacci

        */

        //Ejercicio 5. Determinar si algun elemento de un arr contiene un valor igual a la pos i
        //ejercicio5();

        //Ejercicio 6. Implementar ordenamientos de selección y burbujeo.
        //Ambos tienen complejidad big-On2
        //ordenamientoSeleccion(arrDesordenado);
        ordenamientoBurbujeo(arrDesordenado);
    
        //Ejercicio 7. Implementar algoritmo de ordenamiento mergesort y quicksort.

        //mergeSort(arrDesordenado);

    }

    /*----------------------------------------------------------------------------*/

    public static boolean estaOrdenado(int [] arr) {
        return estaOrdenado(arr, 0);
    }

    private static boolean estaOrdenado(int [] arr, int i) {
        if (i >= arr.length-1) {
            return true;
        }
        if (arr[i] > arr[i+1]) {
            return false;
        }
        return estaOrdenado(arr, i+1);
    }

    /*----------------------------------------------------------------------------*/
    
    public static int buscar(int [] arr, int num) {
        return buscar(arr, 0, num);
    }

    private static int buscar(int [] arr, int i, int num) {
        if (i >= arr.length) {
            return -1;
        }
        if (i <= arr.length-1) {
            if (arr[i] != num) {
               return buscar(arr, i+1, num);
            }
        }
        return i+1;
    }

    /*----------------------------------------------------------------------------*/
    
    public static void convertir(int num) {
        if (num > 0) {
            System.out.println(num%2);
            num = num/2;
            convertir(num);
        }
    }

    /*----------------------------------------------------------------------------*/

    //EJERCICIO 4 HACER

    /*----------------------------------------------------------------------------*/

    //Ejercicio 5. 
    public static void ejercicio5() {
        int [] arr = new int[]{-2, -1, 0, 2, 4, 6, 10};
        boolean encontrado = ejercicio5(arr,0, arr.length-1);
        if (encontrado) {
            System.out.println("Elemento encontrado");
        } else {
            System.out.println("Elemento no encontrado");
        }
    }
    
    private static boolean ejercicio5(int[] A, int inicio, int fin) {
        if (inicio > fin) {
            return false;
        }
    
        int medio = (inicio + fin) / 2;
    
        if (A[medio] == medio) {
            return true;
        } else if (A[medio] > medio) {
            // Buscar en la mitad izquierda (los elementos a la derecha serán mayores)
            return ejercicio5(A, inicio, medio - 1);
        } else {
            // Buscar en la mitad derecha (los elementos a la izquierda serán menores)
            return ejercicio5(A, medio + 1, fin);
        }
    }

    /*----------------------------------------------------------------------------*/

    //Ejercicio 6. 
    public static void ordenamientoSeleccion(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            int primero = i;

            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[primero]) {
                    primero = j;
                }
            }
            int aux = arr[i];
            arr[i] = arr[primero];
            arr[primero] = aux; 
        }
        mostrarArr(arr);
    }

    public static void ordenamientoBurbujeo(int [] arr) {
        int aux, i = 0;
        boolean intercambio = true;
        while (intercambio) {
            intercambio = false;
            i++;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j+1]) {
                    aux = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = aux;
                    intercambio = true;
                }
            }

        }
        mostrarArr(arr);
    }

    public static <T> void mostrarArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", "); // Separador entre elementos
            }
        }
        System.out.println(); // Salto de línea al final
    }

    /*----------------------------------------------------------------------------*/

    //Ejercicio 7.
    //Estan las clases creadas.

    //Ejercicio 8.
    //El algoritmo Collction.Sort utilizar QuickSort debido a su rendimiento promedio. 
    //Utilizado con arrays primitivos.

}
