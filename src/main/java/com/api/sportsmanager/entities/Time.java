package com.api.sportsmanager.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Time {

    private long idTime;
    private String nomeTime;
    private int numVitoria;
    private int numEmpate;
    private int numDerrota;
    private LocalDateTime dataCriacao;
    private List<UsuarioTime> usuarioTime;
    private List<EsporteTime> esporteTime;
    private List<TimeJogo> timeJogo;
    private String fotoTime;

    public Time() {
        this.idTime = 0;
        this.nomeTime = "";
        this.numVitoria = 0;
        this.numEmpate = 0;
        this.numDerrota = 0;
        this.dataCriacao = LocalDateTime.now();
        this.usuarioTime = new ArrayList<UsuarioTime>();
        this.esporteTime = new ArrayList<EsporteTime>();
        this.timeJogo = new ArrayList<TimeJogo>();
        this.fotoTime = "";
    }

    public Time(long id_time, String nomeTime, int numVitoria, int numEmpate, int numDerrota, LocalDateTime dataCriacao,
            List<UsuarioTime> usuarioTime, List<EsporteTime> esporteTime, List<TimeJogo> timeJogo, String fotoTime) {
        this.idTime = id_time;
        this.nomeTime = nomeTime;
        this.numVitoria = numVitoria;
        this.numEmpate = numEmpate;
        this.numDerrota = numDerrota;
        this.dataCriacao = dataCriacao;
        this.usuarioTime = usuarioTime;
        this.esporteTime = esporteTime;
        this.timeJogo = timeJogo;
        this.fotoTime = fotoTime;
    }

    public String getFotoTime() {
        return fotoTime;
    }

    public void setFotoTime(String fotoTime) {
        this.fotoTime = fotoTime;
    }

    public List<TimeJogo> getTimeJogo() {
        return timeJogo;
    }

    public void setTimeJogo(List<TimeJogo> timeJogo) {
        this.timeJogo = timeJogo;
    }

    public List<EsporteTime> getEsporteTime() {
        return esporteTime;
    }

    public void setEsporteTime(List<EsporteTime> esporteTime) {
        this.esporteTime = esporteTime;
    }

    public List<UsuarioTime> getUsuarioTime() {
        return usuarioTime;
    }

    public void setUsuarioTime(List<UsuarioTime> usuarioTime) {
        this.usuarioTime = usuarioTime;
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

    @Override
    public String toString() {
        return "Time [dataCriacao=" + dataCriacao + ", esporteTime=" + esporteTime + ", fotoTime=" + fotoTime
                + ", idTime=" + idTime + ", nomeTime=" + nomeTime + ", numDerrota=" + numDerrota + ", numEmpate="
                + numEmpate + ", numVitoria=" + numVitoria + ", timeJogo=" + timeJogo + ", usuarioTime=" + usuarioTime
                + "]";
    }
}