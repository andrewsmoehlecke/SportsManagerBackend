package com.api.sportsmanager.dto;

import java.time.LocalDateTime;

public class CampeonatoDto {
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
    private long idTimeVencedor;
    private long idEsporte;

    public CampeonatoDto() {
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
        this.setIdTimeVencedor(0);
        this.setIdEsporte(0);
    }

    public CampeonatoDto(long idCampeonato, String nome, String informacoes, String regras, LocalDateTime data_inicio,
            LocalDateTime data_final, int qtdGrupos, int qtdTimesPorGrupo, int fasesPlayoffs,
            boolean possuiLowerBracket, long idTimeVencedor, long idEsporte) {
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
        this.setIdTimeVencedor(idTimeVencedor);
        this.setIdEsporte(idEsporte);
    }

    public long getIdEsporte() {
        return idEsporte;
    }

    public void setIdEsporte(long idEsporte) {
        this.idEsporte = idEsporte;
    }

    public long getIdTimeVencedor() {
        return idTimeVencedor;
    }

    public void setIdTimeVencedor(long idTimeVencedor) {
        this.idTimeVencedor = idTimeVencedor;
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
}
