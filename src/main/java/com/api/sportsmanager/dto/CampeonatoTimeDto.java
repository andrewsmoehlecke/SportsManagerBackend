package com.api.sportsmanager.dto;

public class CampeonatoTimeDto {
    private long idCampeonatoTime;
    private long idCampeonato;
    private long idTime;

    public CampeonatoTimeDto() {
        this.idCampeonatoTime = 0;
        this.idCampeonato = 0;
        this.idTime = 0;
    }

    public CampeonatoTimeDto(long idCampeonatoTime, long idCampeonato, long idTime) {
        this.idCampeonatoTime = idCampeonatoTime;
        this.idCampeonato = idCampeonato;
        this.idTime = idTime;
    }

    public long getIdCampeonatoTime() {
        return idCampeonatoTime;
    }

    public void setIdCampeonatoTime(long idCampeonatoTime) {
        this.idCampeonatoTime = idCampeonatoTime;
    }

    public long getIdCampeonato() {
        return idCampeonato;
    }

    public void setIdCampeonato(long idCampeonato) {
        this.idCampeonato = idCampeonato;
    }

    public long getIdTime() {
        return idTime;
    }

    public void setIdTime(long idTime) {
        this.idTime = idTime;
    }
}
