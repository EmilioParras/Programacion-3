package practico2;

public class MergeSort {
    
    private int[] numbers;
    private int[] helper;
    private int size;

    public void sort(int [] arr) {
        this.numbers = arr;
        this.size = arr.length;
        this.helper = new int[size];
        mergesort(0, size-1);
    }

    private void mergesort(int low, int high) {

        if (low < high) {

            //Obtengo mitad del arr.
            int middle = (low + high) / 2;

            //Sigo dividiendo el arr hasta que no lo pueda dividir mas.
            mergesort(low, middle);
            mergesort(middle+1, high);
            
            //Combino ambas mitad ordenadas
            merge(low, middle, high);
        }

    }

    private void merge(int low, int middle, int high) {

        //Copio ambas partes en el arr helper
        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }

        int i = low;
        int j = middle+1;
        int k = low;

        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                numbers[k] = helper[i];
                i++;
            } else {
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            numbers[k] = helper[i];
            k++;
            i++;
        }
        while (j <= high) {
            numbers[k] = helper[j];
            k++;
            j++;
        }
    }

}
