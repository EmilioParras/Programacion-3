package practico2;

public class QuickSort {
    
    public void sort(int [] arr) {
        quickSort(arr, 0, arr.length-1);
    }

    private void quickSort(int [] arr, int low, int high) {
        if (low < high) {
            //Obtener el indice de particion
            int p = partition(arr,low,high);

            //Ordeno recursivamente las dos partes
            quickSort(arr, low, p-1);
            quickSort(arr, p+1, high);
        }
    }

    private int partition(int [] arr, int low, int high) {
        int pivot = arr[high]; //Tomamos el ultimo elemento como pivot
        int i = (low - 1); //Indice del elemento menor

        for (int j = low; j < high; j++) {
            // Si el elemento actual es menor que el pivote
            if (arr[j] < pivot) {
                i++; // -1 -> 0
                //Intercambio arr[i] por arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Intercambiar arr[i+1] y arr[high] (el pivote)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

}
