package com.api.sportsmanager.entities;

public class EsporteTime {
    private long idEsporteTime;
    private Esporte esporte;
    private Time time;

    public EsporteTime() {
        this.idEsporteTime = 0;
        this.esporte = new Esporte();
        this.time = new Time();
    }

    public EsporteTime(long idEsporteTime, Esporte esporte, Time time) {
        this.idEsporteTime = idEsporteTime;
        this.esporte = esporte;
        this.time = time;
    }

    public long getIdEsporteTime() {
        return idEsporteTime;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Esporte getEsporte() {
        return esporte;
    }

    public void setEsporte(Esporte esporte) {
        this.esporte = esporte;
    }

    public void setIdEsporteTime(long idEsporteTime) {
        this.idEsporteTime = idEsporteTime;
    }

    @Override
    public String toString() {
        return "EsporteTime [esporte=" + esporte + ", idEsporteTime=" + idEsporteTime + ", time=" + time + "]";
    }
}
