package com.api.sportsmanager.dto;

import java.time.LocalDateTime;

public class TimeDto {
    private long idTime;
    private String nomeTime;
    private int numVitoria;
    private int numEmpate;
    private int numDerrota;
    private LocalDateTime dataCriacao;

    public TimeDto() {
        this.idTime = 0;
        this.nomeTime = "";
        this.numVitoria = 0;
        this.numEmpate = 0;
        this.numDerrota = 0;
        this.dataCriacao = LocalDateTime.now();
    }

    public TimeDto(long id_time, String nomeTime, int numVitoria, int numEmpate, int numDerrota,
            LocalDateTime dataCriacao) {
        this.idTime = id_time;
        this.nomeTime = nomeTime;
        this.numVitoria = numVitoria;
        this.numEmpate = numEmpate;
        this.numDerrota = numDerrota;
        this.dataCriacao = dataCriacao;
    }

    public String getNomeTime() {
        return nomeTime;
    }

    public void setNomeTime(String nomeTime) {
        this.nomeTime = nomeTime;
    }

    public long getIdTime() {
        return idTime;
    }

    public void setIdTime(long idTime) {
        this.idTime = idTime;
    }

    public int getNumVitoria() {
        return numVitoria;
    }

    public void setNumVitoria(int numVitoria) {
        this.numVitoria = numVitoria;
    }

    public int getNumEmpate() {
        return numEmpate;
    }

    public void setNumEmpate(int numEmpate) {
        this.numEmpate = numEmpate;
    }

    public int getNumDerrota() {
        return numDerrota;
    }

    public void setNumDerrota(int numDerrota) {
        this.numDerrota = numDerrota;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
