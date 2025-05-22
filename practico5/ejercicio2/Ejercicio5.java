package ejercicio2;

public class Ejercicio5 {
 
    private int caminoMasCorto = -1;
    
    public void ejercicio5(int [][] mat, Casilla origen, Casilla destino) {
        mat = new int[3][3];

        int caminoActual = 0;
        ejercicio5(mat, origen, destino, caminoActual);
    }

    private void ejercicio5(int [][] mat, Casilla actual, Casilla destino, int caminoActual) {
        if (actual.equals(destino)) {
            if (caminoActual < caminoMasCorto || caminoMasCorto == -1) {
                caminoMasCorto = caminoActual;
            }
        } else {
            caminoActual += actual.getValorPos();
            actual.setVisitado(true);

            if (actual.getCasillaEste() != null) {
                ejercicio5(mat, actual.getCasillaEste(), destino, caminoActual);
            } else if (actual.getCasillaNorte() != null){
                ejercicio5(mat, actual.getCasillaNorte(), destino, caminoActual);
            }else if (actual.getCasillaOeste() != null){
                ejercicio5(mat, actual.getCasillaOeste(), destino, caminoActual);
            }else if (actual.getCasillaSur() != null){
                ejercicio5(mat, actual.getCasillaSur(), destino, caminoActual);
            }

            actual.setVisitado(false);
            caminoActual -= actual.getValorPos();
        }

    }

}
