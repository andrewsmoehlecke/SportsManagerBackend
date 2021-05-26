package com.api.sportsmanager.entities;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Time {

    private long id_time;
    private String nomeTime;
    private int numVitoria;
    private int numEmpates;
    private int numDerrota;
    private LocalDate dataCriacao;
    private List<UsuarioTime> usuarioTime;
    private List<EsporteTime> esporteTime;
    private List<TimeJogo> timeJogo;
    private List<CampeonatoTime> campeonatoTime;
    private List<Treino> treino;

    public Time() {
        this.id_time = 0;
        this.nomeTime = "";
        this.numVitoria = 0;
        this.numEmpates = 0;
        this.numDerrota = 0;
        this.dataCriacao = LocalDate.now();
        this.usuarioTime = new ArrayList<UsuarioTime>();
        this.esporteTime = new ArrayList<EsporteTime>();
        this.timeJogo = new ArrayList<TimeJogo>();
        this.campeonatoTime = new ArrayList<CampeonatoTime>();
        this.treino = new ArrayList<Treino>();
    }

    public Time(long id_time, String nomeTime, int numVitoria, int numEmpates, int numDerrota, LocalDate dataCriacao,
            List<UsuarioTime> usuarioTime, List<EsporteTime> esporteTime, List<TimeJogo> timeJogo,
            List<CampeonatoTime> campeonatoTime, List<Treino> treino) {
        this.id_time = id_time;
        this.nomeTime = nomeTime;
        this.numVitoria = numVitoria;
        this.numEmpates = numEmpates;
        this.numDerrota = numDerrota;
        this.dataCriacao = dataCriacao;
        this.usuarioTime = usuarioTime;
        this.esporteTime = esporteTime;
        this.timeJogo = timeJogo;
        this.campeonatoTime = campeonatoTime;
        this.treino = treino;
    }

    public List<Treino> getTreino() {
        return treino;
    }

    public void setTreino(List<Treino> treino) {
        this.treino = treino;
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

    public long getId_time() {
        return id_time;
    }

    public void setId_time(long id_time) {
        this.id_time = id_time;
    }

    public int getNumVitoria() {
        return numVitoria;
    }

    public void setNumVitoria(int numVitoria) {
        this.numVitoria = numVitoria;
    }

    public int getNumEmpates() {
        return numEmpates;
    }

    public void setNumEmpates(int numEmpates) {
        this.numEmpates = numEmpates;
    }

    public int getNumDerrota() {
        return numDerrota;
    }

    public void setNumDerrota(int numDerrota) {
        this.numDerrota = numDerrota;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public String toString() {
        return "Time [campeonatoTime=" + campeonatoTime + ", dataCriacao=" + dataCriacao + ", esporteTime="
                + esporteTime + ", id_time=" + id_time + ", nomeTime=" + nomeTime + ", numDerrota=" + numDerrota
                + ", numEmpates=" + numEmpates + ", numVitoria=" + numVitoria + ", timeJogo=" + timeJogo + ", treino="
                + treino + ", usuarioTime=" + usuarioTime + "]";
    }

}