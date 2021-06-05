package com.api.sportsmanager.dto;

import java.time.LocalDateTime;

public class TimeJogoDto {
    private long idTimeJogo;
    private String local;
    private int pontuacaoTime1;
    private int pontuacaoTime2;
    private LocalDateTime dataJogo;
    private long idTime;
    private long idJogo;

    public TimeJogoDto() {
        this.idTimeJogo = 0;
        this.local = "";
        this.pontuacaoTime1 = 0;
        this.pontuacaoTime2 = 0;
        this.dataJogo = LocalDateTime.now();
        this.setIdTime(0);
        this.setIdJogo(0);
    }

    public TimeJogoDto(long idTimeJogo, String local, int pontuacaoTime1, int pontuacaoTime2, LocalDateTime dataJogo,
            long idTime, long idJogo) {
        this.idTimeJogo = idTimeJogo;
        this.local = local;
        this.pontuacaoTime1 = pontuacaoTime1;
        this.pontuacaoTime2 = pontuacaoTime2;
        this.dataJogo = dataJogo;
        this.setIdTime(idTime);
        this.setIdJogo(idJogo);
    }

    public long getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(long idJogo) {
        this.idJogo = idJogo;
    }

    public long getIdTime() {
        return idTime;
    }

    public void setIdTime(long idTime) {
        this.idTime = idTime;
    }

    public long getIdTimeJogo() {
        return idTimeJogo;
    }

    public void setIdTimeJogo(long idTimeJogo) {
        this.idTimeJogo = idTimeJogo;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
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

    public LocalDateTime getDataJogo() {
        return dataJogo;
    }

    public void setDataJogo(LocalDateTime dataJogo) {
        this.dataJogo = dataJogo;
    }
}
