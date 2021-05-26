package com.api.sportsmanager.entities;

public class EstrategiaTreino {
    private long idEstrategiaTreino;
    private Treino treino;
    private Estrategia estrategia;

    public EstrategiaTreino() {
        this.idEstrategiaTreino = 0;
        this.treino = new Treino();
        this.estrategia = new Estrategia();
    }

    public EstrategiaTreino(long idEstrategiaTreino, Treino treino, Estrategia estrategia) {
        this.idEstrategiaTreino = idEstrategiaTreino;
        this.treino = treino;
        this.estrategia = estrategia;
    }

    public long getIdEstrategiaTreino() {
        return idEstrategiaTreino;
    }

    public void setIdEstrategiaTreino(long idEstrategiaTreino) {
        this.idEstrategiaTreino = idEstrategiaTreino;
    }

    public Treino getTreino() {
        return treino;
    }

    public void setTreino(Treino treino) {
        this.treino = treino;
    }

    public Estrategia getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(Estrategia estrategia) {
        this.estrategia = estrategia;
    }

    @Override
    public String toString() {
        return "EstrategiaTreino [estrategia=" + estrategia + ", idEstrategiaTreino=" + idEstrategiaTreino + ", treino="
                + treino + "]";
    }
}
