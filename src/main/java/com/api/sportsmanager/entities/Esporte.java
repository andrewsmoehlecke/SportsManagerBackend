package com.api.sportsmanager.entities;
import java.util.ArrayList;
import java.util.List;

public class Esporte {
    private long idEsporte;
    private String nome;
    private String logo;
    private String plataforma;
    private List<EsporteTime> esporteTime;
    private List<FuncaoTime> funcaoTime;
    private List<Campeonato> campeonato;

    public Esporte(long idEsporte, String nome, String logo, String plataforma, List<EsporteTime> esporteTime,
            List<FuncaoTime> funcaoTime, List<Campeonato> campeonato) {
        this.idEsporte = idEsporte;
        this.nome = nome;
        this.logo = logo;
        this.plataforma = plataforma;
        this.esporteTime = esporteTime;
        this.funcaoTime = funcaoTime;
        this.campeonato = campeonato;
    }

    public Esporte() {
        this.idEsporte = 0;
        this.nome = "";
        this.logo = "";
        this.logo = "";
        this.plataforma = "";
        this.esporteTime = new ArrayList<EsporteTime>();
        this.funcaoTime = new ArrayList<FuncaoTime>();
        this.campeonato = new ArrayList<Campeonato>();
    }

    public List<Campeonato> getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(List<Campeonato> campeonato) {
        this.campeonato = campeonato;
    }

    public List<FuncaoTime> getFuncaoTime() {
        return funcaoTime;
    }

    public void setFuncaoTime(List<FuncaoTime> funcaoTime) {
        this.funcaoTime = funcaoTime;
    }

    public List<EsporteTime> getEsporteTime() {
        return esporteTime;
    }

    public void setEsporteTime(List<EsporteTime> esporteTime) {
        this.esporteTime = esporteTime;
    }

    public long getIdEsporte() {
        return idEsporte;
    }

    public void setIdEsporte(long idEsporte) {
        this.idEsporte = idEsporte;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    @Override
    public String toString() {
        return "Esporte [campeonato=" + campeonato + ", esporteTime=" + esporteTime + ", funcaoTime=" + funcaoTime
                + ", idEsporte=" + idEsporte + ", logo=" + logo + ", nome=" + nome + ", plataforma=" + plataforma + "]";
    }

}
