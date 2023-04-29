package models.Estados;

import models.Partida;

public class DeInicio implements Estado {
    private Partida partida;
    @Override
    public void deConfiguracion() {

    }

    @Override
    public void deInicio() {
        iniciarTablero();
        rellenerTablero();
        partida.setEstado(new EnCurso());
    }

    @Override
    public void enCurso() {

    }

    @Override
    public void deJaque() {

    }

    @Override
    public void deJaqueMate() {

    }

    @Override
    public void deEmpate() {

    }

    @Override
    public void deFinalizacion() {

    }

    @Override
    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    private void iniciarTablero(){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(i == 0 || j == 0 || i == 4 || j == 4){
                    partida.getTablero()[i][j] = 1;
                }
            }
        }
    }

    private void rellenerTablero(){
        partida.getTablero()[1][2] = 24;
        partida.getTablero()[3][1] = 34;
        partida.getTablero()[1][3] = 24;
    }
}
