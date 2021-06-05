package com.api.sportsmanager.dto;

public class EsporteTimeDto {
    private long idEsporteTime;
    private long idEsporte;
    private long idTime;

    public EsporteTimeDto() {
        this.idEsporteTime = 0;
        this.setIdEsporte(0);
        this.setIdTime(0);
    }

    public EsporteTimeDto(long idEsporteTime, long idEsporte, long idTime) {
        this.idEsporteTime = idEsporteTime;
        this.setIdEsporte(idEsporte);
        this.setIdTime(idTime);
    }

    public long getIdTime() {
        return idTime;
    }

    public void setIdTime(long idTime) {
        this.idTime = idTime;
    }

    public long getIdEsporte() {
        return idEsporte;
    }

    public void setIdEsporte(long idEsporte) {
        this.idEsporte = idEsporte;
    }

    public long getIdEsporteTime() {
        return idEsporteTime;
    }

    public void setIdEsporteTime(long idEsporteTime) {
        this.idEsporteTime = idEsporteTime;
    }
}
