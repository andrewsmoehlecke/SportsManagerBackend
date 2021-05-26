package com.api.sportsmanager.entities;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Treino {
    private long idTreino;
    private LocalDateTime dataTreino;
    private List<EstrategiaTreino> estrategiaTreino;
    private Time time;

    public Treino() {
        this.idTreino = 0;
        this.dataTreino = LocalDateTime.now();
        this.estrategiaTreino = new ArrayList<EstrategiaTreino>();
        this.time = new Time();
    }

    public Treino(long idTreino, LocalDateTime dataTreino, List<EstrategiaTreino> estrategiaTreino, Time time) {
        this.idTreino = idTreino;
        this.dataTreino = dataTreino;
        this.estrategiaTreino = estrategiaTreino;
        this.time = time;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public List<EstrategiaTreino> getEstrategiaTreino() {
        return estrategiaTreino;
    }

    public void setEstrategiaTreino(List<EstrategiaTreino> estrategiaTreino) {
        this.estrategiaTreino = estrategiaTreino;
    }

    public long getIdTreino() {
        return idTreino;
    }

    public void setIdTreino(long idTreino) {
        this.idTreino = idTreino;
    }

    public LocalDateTime getDataTreino() {
        return dataTreino;
    }

    public void setDataTreino(LocalDateTime dataTreino) {
        this.dataTreino = dataTreino;
    }

    @Override
    public String toString() {
        return "Treino [dataTreino=" + dataTreino + ", estrategiaTreino=" + estrategiaTreino + ", idTreino=" + idTreino
                + ", time=" + time + "]";
    }

}
