package com.api.sportsmanager.dto;

public class EsporteDto {
    private long idEsporte;
    private String nome;
    private String logo;
    private String plataforma;

    public EsporteDto(long idEsporte, String nome, String logo, String plataforma) {
        this.idEsporte = idEsporte;
        this.nome = nome;
        this.logo = logo;
        this.plataforma = plataforma;
    }

    public EsporteDto() {
        this.idEsporte = 0;
        this.nome = "";
        this.logo = "";
        this.logo = "";
        this.plataforma = "";
    }

    public long getIdEsporte() {
        return idEsporte;
    }

    public void setIdEsporte(long idEsporte) {
        this.idEsporte = idEsporte;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
}
