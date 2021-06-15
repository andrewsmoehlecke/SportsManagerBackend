package com.api.sportsmanager.dto;

public class FuncaoTimeDto {
    private long idFuncaoTime;
    private String nome;

    public FuncaoTimeDto() {
        this.idFuncaoTime = 0;
        this.nome = "";
    }

    public FuncaoTimeDto(long idFuncaoTime, String nome) {
        this.idFuncaoTime = idFuncaoTime;
        this.nome = nome;
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
