package com.api.sportsmanager.entities;
public class CampeonatoTime {
    private long idCampeonatoTime;
    private Campeonato campeonato;
    private Time time;

    public CampeonatoTime() {
        this.idCampeonatoTime = 0;
        this.campeonato = new Campeonato();
        this.time = new Time();
    }

    public CampeonatoTime(long idCampeonatoTime, Campeonato campeonato, Time time) {
        this.idCampeonatoTime = idCampeonatoTime;
        this.campeonato = campeonato;
        this.time = time;
    }

    public long getIdCampeonatoTime() {
        return idCampeonatoTime;
    }

    public void setIdCampeonatoTime(long idCampeonatoTime) {
        this.idCampeonatoTime = idCampeonatoTime;
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "CampeonatoTime [campeonato=" + campeonato + ", idCampeonatoTime=" + idCampeonatoTime + ", time=" + time
                + "]";
    }

}
