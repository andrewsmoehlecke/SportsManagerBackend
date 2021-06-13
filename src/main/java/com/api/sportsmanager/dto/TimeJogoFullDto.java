package com.api.sportsmanager.dto;

import java.time.LocalDateTime;

public class TimeJogoFullDto {

    private long idTimeJogo;
    private String local;
    private int pontuacaoTime1;
    private int pontuacaoTime2;
    private LocalDateTime dataJogo;
    private TimeDto time1;
    private TimeDto time2;
    private String titulo;

    public TimeJogoFullDto() {
        this.idTimeJogo = 0;
        this.local = "";
        this.pontuacaoTime1 = 0;
        this.pontuacaoTime2 = 0;
        this.dataJogo = LocalDateTime.now();
        this.time1 = new TimeDto();
        this.time2 = new TimeDto();
        this.titulo = "";
    }

    public TimeJogoFullDto(long idTimeJogo, String local, int pontuacaoTime1, int pontuacaoTime2,
            LocalDateTime dataJogo, TimeDto time1, TimeDto time2, String titulo) {
        this.idTimeJogo = idTimeJogo;
        this.local = local;
        this.pontuacaoTime1 = pontuacaoTime1;
        this.pontuacaoTime2 = pontuacaoTime2;
        this.dataJogo = dataJogo;
        this.time1 = time1;
        this.time2 = time2;
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public TimeDto getTime1() {
        return time1;
    }

    public void setTime1(TimeDto time1) {
        this.time1 = time1;
    }

    public TimeDto getTime2() {
        return time2;
    }

    public void setTime2(TimeDto time2) {
        this.time2 = time2;
    }

    @Override
    public String toString() {
        return "TimeJogoFullDto [dataJogo=" + dataJogo + ", idTimeJogo=" + idTimeJogo + ", local=" + local
                + ", pontuacaoTime1=" + pontuacaoTime1 + ", pontuacaoTime2=" + pontuacaoTime2 + ", time1=" + time1
                + ", time2=" + time2 + ", titulo=" + titulo + "]";
    }

}
