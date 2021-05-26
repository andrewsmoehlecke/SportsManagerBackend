package com.api.sportsmanager.entities;
import java.util.ArrayList;
import java.util.List;

public class Estrategia {
    private long idEstrategia;
    private String nome;
    private String tipo;
    private String descricao;
    private List<EstrategiaTreino> estrategiaTreino;

    public Estrategia() {
        this.idEstrategia = 0;
        this.nome = "";
        this.tipo = "";
        this.descricao = "";
        this.estrategiaTreino = new ArrayList<EstrategiaTreino>();
    }

    public Estrategia(long idEstrategia, String nome, String tipo, String descricao,
            List<EstrategiaTreino> estrategiaTreino) {
        this.idEstrategia = idEstrategia;
        this.nome = nome;
        this.tipo = tipo;
        this.descricao = descricao;
        this.estrategiaTreino = estrategiaTreino;
    }

    public long getIdEstrategia() {
        return idEstrategia;
    }

    public void setIdEstrategia(long idEstrategia) {
        this.idEstrategia = idEstrategia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<EstrategiaTreino> getEstrategiaTreino() {
        return estrategiaTreino;
    }

    public void setEstrategiaTreino(List<EstrategiaTreino> estrategiaTreino) {
        this.estrategiaTreino = estrategiaTreino;
    }

    @Override
    public String toString() {
        return "Estrategia [descricao=" + descricao + ", estrategiaTreino=" + estrategiaTreino + ", idEstrategia="
                + idEstrategia + ", nome=" + nome + ", tipo=" + tipo + "]";
    }

}