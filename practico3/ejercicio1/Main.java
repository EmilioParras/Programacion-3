package ejercicio1;
public class Main {
    
    final static int M = 7; // Baldes  
    final static int rp = 1; // Ranuras primarias
    final static int rs = 1; // Ranuras secundarias
    
    public static void main(String[] args) {

        HashingSeparado tabla = new HashingSeparado();   
        HashingSeparadoCrecimiento tablaCrecimiento = new HashingSeparadoCrecimiento();     

        int [] X = {68, 42, 47, 5, 76, 95, 23, 88, 90, 85, 31, 71, 60, 10, 46, 61};
    
        for (int elemento : X) {
            tabla.insertar(elemento);
            tablaCrecimiento.insertar(elemento);
        }

        //tabla.mostrar();
        tablaCrecimiento.mostrar();


    }

}
