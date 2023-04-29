package models;

import java.util.ArrayList;
import java.util.List;

public class Peon {

    public List<int[]> movPosibles(int[][] tablero, int[] posicion){
        List<int[]> movimientosPosibles = new ArrayList<>();
        int[] movimientoPosible;
        //int[][] tablero = tablero;
        int pasos;
        int c = posicion[0];
        int r = posicion[1];

        if(tablero[r][c] / 10 == 2 && posicion[1] == 2 || tablero[r][c] / 10 == 3 && posicion[1] == 7){
            pasos = 2;
        } else {
            pasos = 1;
        }

        if(tablero[r][c] / 10 == 2){
            do{
                r++;
                if(tablero[r][c] == 0){
                    tablero[r][c] += 100;
                    movimientoPosible = new int[] {c,r};
                    movimientosPosibles.add(movimientoPosible);
                    pasos--;
                }
            }while(tablero[r][c] == 100 && pasos > 0);

            c = posicion[0] + 1;
            r = posicion[1] + 1;
            for(int i = 0; i < 2; i++){
                if(tablero[r][c] / 10 == 3 && tablero[r][c] != 1){
                    tablero[r][c] += 100;
                    movimientoPosible = new int[] {c,r};
                    movimientosPosibles.add(movimientoPosible);
                }
                c -= 2;
            }
            c = posicion[0];
            r = posicion[1];
        }

        if(tablero[r][c] / 10 == 3){
            do{
                r--;
                if(tablero[r][c] == 0){
                    tablero[r][c] += 100;
                    movimientoPosible = new int[] {c,r};
                    movimientosPosibles.add(movimientoPosible);
                    pasos--;
                }
            }while(tablero[r][c] == 100 && pasos > 0);

            c = posicion[0] - 1;
            r = posicion[1] - 1;
            for(int i = 0; i < 2; i++){
                if(tablero[r][c] / 10 == 2 && tablero[r][c] != 1){
                    tablero[r][c] += 100;
                    movimientoPosible = new int[] {c,r};
                    movimientosPosibles.add(movimientoPosible);
                }
                c += 2;
            }
        }

        return movimientosPosibles;
    }
}
