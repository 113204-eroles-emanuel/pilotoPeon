package models.Estados;

import models.Partida;

public interface Estado {
    void deConfiguracion();
    void deInicio();
    void enCurso();
    void deJaque();
    void deJaqueMate();
    void deEmpate();
    void deFinalizacion();

    void setPartida(Partida partida);
}
