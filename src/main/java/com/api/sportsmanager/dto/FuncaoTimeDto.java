package com.api.sportsmanager.dto;

public class FuncaoTimeDto {
    private long idFuncaoTime;
    private String nome;
    private long idEsporte;

    public FuncaoTimeDto() {
        this.idFuncaoTime = 0;
        this.nome = "";
        this.setIdEsporte(0);
    }

    public FuncaoTimeDto(long idFuncaoTime, String nome, long idEsporte) {
        this.idFuncaoTime = idFuncaoTime;
        this.nome = nome;
        this.setIdEsporte(idEsporte);
    }

    public long getIdEsporte() {
        return idEsporte;
    }

    public void setIdEsporte(long idEsporte) {
        this.idEsporte = idEsporte;
    }

    public long getIdFuncaoTime() {
        return idFuncaoTime;
    }

    public void setIdFuncaoTime(long idFuncaoTime) {
        this.idFuncaoTime = idFuncaoTime;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
