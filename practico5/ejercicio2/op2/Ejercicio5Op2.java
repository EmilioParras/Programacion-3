package ejercicio2.op2;

public class Ejercicio5Op2 {
    
    private int caminoMasCorto = -1;
    private CasillaOP2 [][] laberinto;

    public Ejercicio5Op2(CasillaOP2[][] laberinto) {
        this.laberinto = laberinto;
    }

    public int ejercicio5(CasillaOP2 origen, CasillaOP2 destino) {

        int[] posOrigen = buscarPosOrigen(origen);
        if (posOrigen == null) {
            return -1;
        }

        int caminoActual = 0;
        ejercicio5(posOrigen[0], posOrigen[1], destino, caminoActual);
        return caminoMasCorto;
    }

    private int[] buscarPosOrigen(CasillaOP2 origen) {
        for (int i = 0; i < laberinto.length; i++) {
            for (int j = 0; j < laberinto[i].length; j++) {
                if (laberinto[i][j] == origen) {
                    return new int[]{i,j};    
                }
            }
        }
        return null;
    }

    private void ejercicio5(int x, int y, CasillaOP2 destino, int caminoActual) {

        CasillaOP2 actual = laberinto[x][y];

        if (actual == destino) {
            if (caminoActual < caminoMasCorto || caminoMasCorto == -1) {
                caminoMasCorto = caminoActual;
            }
        } else {
            caminoActual += actual.getValorPos();
            actual.setVisitado(true);
            if (actual.getEste() && !laberinto[x+1][y].getVisitado() && laberinto[x+1][y] != null) {
                ejercicio5(x+1, y, destino, caminoActual);
            } 
            if (actual.getNorte() && !laberinto[x][y+1].getVisitado() && laberinto[x][y+1] != null) {
                ejercicio5(x, y+1, destino, caminoActual);
            } 
            if (actual.getOeste() && !laberinto[x-1][y].getVisitado() && laberinto[x-1][y]!= null) {
                ejercicio5(x-1, y, destino, caminoActual);
            } 
            if (actual.getSur() && !laberinto[x][y-1].getVisitado() && laberinto[x][y-1] != null) {
                ejercicio5(x, y-1, destino,caminoActual);
            }
        }
        caminoActual -= actual.getValorPos();
        actual.setVisitado(false);
    }

}
