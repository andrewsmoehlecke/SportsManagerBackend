package com.api.sportsmanager.dto;

public class JogoDto {
    private long idJogo;
    private int pontuacaoTime1;
    private int pontuacaoTime2;
    private long idCampeonato;

    public JogoDto() {
        this.idJogo = 0;
        this.pontuacaoTime1 = 0;
        this.pontuacaoTime2 = 0;
        this.setIdCampeonato(0);
    }

    public JogoDto(long idJogo, int pontuacaoTime1, int pontuacaoTime2, long idCampeonato) {
        this.idJogo = idJogo;
        this.pontuacaoTime1 = pontuacaoTime1;
        this.pontuacaoTime2 = pontuacaoTime2;
        this.setIdCampeonato(idCampeonato);
    }

    public long getIdCampeonato() {
        return idCampeonato;
    }

    public void setIdCampeonato(long idCampeonato) {
        this.idCampeonato = idCampeonato;
    }

    public long getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(long idJogo) {
        this.idJogo = idJogo;
    }

    public int getPontuacaoTime1() {
        return pontuacaoTime1;
    }

    public void setPontuacaoTime1(int pontuacaoTime1) {
        this.pontuacaoTime1 = pontuacaoTime1;
    }

    public int getPontuacaoTime2() {
        return pontuacaoTime2;
    }

    public void setPontuacaoTime2(int pontuacaoTime2) {
        this.pontuacaoTime2 = pontuacaoTime2;
    }
}
