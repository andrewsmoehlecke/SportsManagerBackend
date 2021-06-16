package com.api.sportsmanager.dto;

import java.time.LocalDateTime;

public class TimeJogoDto {

    private long idTimeJogo;
    private String local;
    private int pontuacaoTime1;
    private int pontuacaoTime2;
    private LocalDateTime dataJogo;
    private long time1;
    private long time2;

    public TimeJogoDto() {
        this.idTimeJogo = 0;
        this.local = "";
        this.pontuacaoTime1 = 0;
        this.pontuacaoTime2 = 0;
        this.dataJogo = LocalDateTime.now();
        this.setTime1(0);
        this.setTime2(0);
    }

    public TimeJogoDto(long idTimeJogo, String local, int pontuacaoTime1, int pontuacaoTime2, LocalDateTime dataJogo,
            long time1, long time2) {
        this.idTimeJogo = idTimeJogo;
        this.local = local;
        this.pontuacaoTime1 = pontuacaoTime1;
        this.pontuacaoTime2 = pontuacaoTime2;
        this.dataJogo = dataJogo;
        this.time1 = time1;
        this.time2 = time2;
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

    public long getTime1() {
        return time1;
    }

    public void setTime1(long time1) {
        this.time1 = time1;
    }

    public long getTime2() {
        return time2;
    }

    public void setTime2(long time2) {
        this.time2 = time2;
    }
}
