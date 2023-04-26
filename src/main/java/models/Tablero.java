package models;

import java.util.List;

public class Tablero {
    private int[][] escaques = new int[5][5];

    public Tablero() {
        iniciarEscaques();
        rellenerEscaques();
    }

    public int[][] getEscaques() {
        return escaques;
    }

    public void setEscaques(int[][] escaques) {
        this.escaques = escaques;
    }
    public void borrarPosibles(List<int[]> movimientosPosibles){
        for(int[] movimientoPosible : movimientosPosibles){
            escaques[movimientoPosible[1]][movimientoPosible[0]] -= 100;
        }
    }
    public int getContenidoEscaque(int[] posicion){
        return getEscaques()[posicion[1]][posicion[0]];
    }
    public void setContenidoEscaque(int[] posicion, int contenido){
        getEscaques()[posicion[1]][posicion[0]] = contenido;
    }
    public void movimiento(int[] posicion1, int[] posicion2){
        int contenido = getContenidoEscaque(posicion1);
        setContenidoEscaque(posicion2, contenido);
        setContenidoEscaque(posicion1, 0);
    }
    private void iniciarEscaques(){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(i == 0 || j == 0 || i == 4 || j == 4){
                    escaques[i][j] = 1;
                }
            }
        }
    }

    private void rellenerEscaques(){
        escaques[1][2] = 24;
        escaques[3][1] = 34;
        escaques[1][3] = 24;
    }

}

