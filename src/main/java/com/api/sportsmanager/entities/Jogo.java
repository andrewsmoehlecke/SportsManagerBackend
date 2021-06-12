package com.api.sportsmanager.entities;

import java.util.ArrayList;
import java.util.List;

public class Jogo {
    private long idJogo;
    private int pontuacaoTime1;
    private int pontuacaoTime2;
    private List<TimeJogo> timeJogo;

    public Jogo() {
        this.idJogo = 0;
        this.pontuacaoTime1 = 0;
        this.pontuacaoTime2 = 0;
        this.timeJogo = new ArrayList<TimeJogo>();
    }

    public Jogo(long idJogo, int pontuacaoTime1, int pontuacaoTime2, List<TimeJogo> timeJogo) {
        this.idJogo = idJogo;
        this.pontuacaoTime1 = pontuacaoTime1;
        this.pontuacaoTime2 = pontuacaoTime2;
        this.timeJogo = timeJogo;
    }

    public List<TimeJogo> getTimeJogo() {
        return timeJogo;
    }

    public void setTimeJogo(List<TimeJogo> timeJogo) {
        this.timeJogo = timeJogo;
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

    @Override
    public String toString() {
        return "Jogo [ idJogo=" + idJogo + ", pontuacaoTime1=" + pontuacaoTime1 + ", pontuacaoTime2=" + pontuacaoTime2
                + ", timeJogo=" + timeJogo + "]";
    }

}
