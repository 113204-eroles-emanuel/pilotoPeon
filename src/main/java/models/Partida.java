package models;

import models.Estados.DeInicio;
import models.Estados.Estado;

import java.util.List;

public class Partida {
    private Estado estado;
    private int[][] tablero = new int[5][5];
    private Peon peon = new Peon();

    public Partida() {
        setEstado(new DeInicio());
    }

    public void setEstado(Estado estado){
        this.estado = estado;
        this.estado.setPartida(this);
    }

    public int[][] getTablero() {
        return tablero;
    }

    public void setTablero(int[][] tablero) {
        this.tablero = tablero;
    }
    public void borrarPosibles(List<int[]> movimientosPosibles){
        for(int[] movimientoPosible : movimientosPosibles){
            tablero[movimientoPosible[1]][movimientoPosible[0]] -= 100;
        }
    }
    public int getContenidoEscaque(int[] posicion){
        return getTablero()[posicion[1]][posicion[0]];
    }
    public void setContenidoEscaque(int[] posicion, int contenido){
        getTablero()[posicion[1]][posicion[0]] = contenido;
    }
    List<int[]> movimientosPosibles;
    int[] posicionVieja;
    public void movimiento(int[] posicionBoton, boolean segundoTouch){

        int contenidoEscaque = getContenidoEscaque(posicionBoton); // no
        int contenidoPosVieja;
        if (!segundoTouch && contenidoEscaque / 10 == turno) {
            movimientosPosibles = peon.movPosibles(this.tablero, posicionBoton); // no

            posicionVieja = posicionBoton; // no
            segundoTouch = true; // no
        } else if (segundoTouch && contenidoEscaque >= 100) {
            borrarPosibles(movimientosPosibles); // no

            contenidoPosVieja = getContenidoEscaque(posicionVieja);
            setContenidoEscaque(posicionBoton, contenidoPosVieja);
            setContenidoEscaque(posicionVieja, 0);


            segundoTouch = false; // no

            cambiarTurno(); // no
        }





    }

    int turno = 0;

    public void cambiarTurno(){
        if(turno == 2){
            turno = 3;
        } else {
            turno = 2;
        }
    }

}
