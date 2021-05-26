package com.api.sportsmanager.entities;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Campeonato {
    private long idCampeonato;
    private String nome;
    private String informacoes;
    private String regras;
    private LocalDateTime data_inicio;
    private LocalDateTime data_final;
    private int qtdGrupos;
    private int qtdTimesPorGrupo;
    private int fasesPlayoffs;
    private boolean possuiLowerBracket;
    private Time timeVencedor;
    private Esporte esporte;
    private List<CampeonatoTime> campeonatoTime;
    private List<Jogo> jogos;

    public Campeonato() {
        this.idCampeonato = 0;
        this.nome = "";
        this.informacoes = "";
        this.regras = "";
        this.data_inicio = LocalDateTime.now();
        this.data_final = LocalDateTime.now();
        this.qtdGrupos = 0;
        this.qtdTimesPorGrupo = 0;
        this.fasesPlayoffs = 0;
        this.possuiLowerBracket = false;
        this.timeVencedor = new Time();
        this.esporte = new Esporte();
        this.campeonatoTime = new ArrayList<CampeonatoTime>();
        this.jogos = new ArrayList<Jogo>();
    }

    public Campeonato(long idCampeonato, String nome, String informacoes, String regras, LocalDateTime data_inicio,
            LocalDateTime data_final, int qtdGrupos, int qtdTimesPorGrupo, int fasesPlayoffs,
            boolean possuiLowerBracket, Time timeVencedor, Esporte esporte, List<CampeonatoTime> campeonatoTime,
            List<Jogo> jogos) {
        this.idCampeonato = idCampeonato;
        this.nome = nome;
        this.informacoes = informacoes;
        this.regras = regras;
        this.data_inicio = data_inicio;
        this.data_final = data_final;
        this.qtdGrupos = qtdGrupos;
        this.qtdTimesPorGrupo = qtdTimesPorGrupo;
        this.fasesPlayoffs = fasesPlayoffs;
        this.possuiLowerBracket = possuiLowerBracket;
        this.timeVencedor = timeVencedor;
        this.esporte = esporte;
        this.campeonatoTime = campeonatoTime;
        this.jogos = jogos;
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos;
    }

    public List<CampeonatoTime> getCampeonatoTime() {
        return campeonatoTime;
    }

    public void setCampeonatoTime(List<CampeonatoTime> campeonatoTime) {
        this.campeonatoTime = campeonatoTime;
    }

    public boolean isPossuiLowerBracket() {
        return possuiLowerBracket;
    }

    public void setPossuiLowerBracket(boolean possuiLowerBracket) {
        this.possuiLowerBracket = possuiLowerBracket;
    }

    public int getFasesPlayoffs() {
        return fasesPlayoffs;
    }

    public void setFasesPlayoffs(int fasesPlayoffs) {
        this.fasesPlayoffs = fasesPlayoffs;
    }

    public int getQtdTimesPorGrupo() {
        return qtdTimesPorGrupo;
    }

    public void setQtdTimesPorGrupo(int qtdTimesPorGrupo) {
        this.qtdTimesPorGrupo = qtdTimesPorGrupo;
    }

    public int getQtdGrupos() {
        return qtdGrupos;
    }

    public void setQtdGrupos(int qtdGrupos) {
        this.qtdGrupos = qtdGrupos;
    }

    public long getIdCampeonato() {
        return idCampeonato;
    }

    public void setIdCampeonato(long idCampeonato) {
        this.idCampeonato = idCampeonato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getInformacoes() {
        return informacoes;
    }

    public void setInformacoes(String informacoes) {
        this.informacoes = informacoes;
    }

    public String getRegras() {
        return regras;
    }

    public void setRegras(String regras) {
        this.regras = regras;
    }

    public LocalDateTime getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(LocalDateTime data_inicio) {
        this.data_inicio = data_inicio;
    }

    public LocalDateTime getData_final() {
        return data_final;
    }

    public void setData_final(LocalDateTime data_final) {
        this.data_final = data_final;
    }

    public Time getTimeVencedor() {
        return timeVencedor;
    }

    public void setTimeVencedor(Time timeVencedor) {
        this.timeVencedor = timeVencedor;
    }

    public Esporte getEsporte() {
        return esporte;
    }

    public void setEsporte(Esporte esporte) {
        this.esporte = esporte;
    }

    @Override
    public String toString() {
        return "Campeonato [campeonatoTime=" + campeonatoTime + ", data_final=" + data_final + ", data_inicio="
                + data_inicio + ", esporte=" + esporte + ", fasesPlayoffs=" + fasesPlayoffs + ", idCampeonato="
                + idCampeonato + ", informacoes=" + informacoes + ", jogos=" + jogos + ", nome=" + nome
                + ", possuiLowerBracket=" + possuiLowerBracket + ", qtdGrupos=" + qtdGrupos + ", qtdTimesPorGrupo="
                + qtdTimesPorGrupo + ", regras=" + regras + ", timeVencedor=" + timeVencedor + "]";
    }

}