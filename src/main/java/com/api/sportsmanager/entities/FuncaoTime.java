package com.api.sportsmanager.entities;

import java.util.ArrayList;
import java.util.List;

public class FuncaoTime {
    private long idFuncaoTime;
    private String nome;
    private List<UsuarioTime> usuarioTime;

    public FuncaoTime() {
        this.idFuncaoTime = 0;
        this.nome = "";
        this.usuarioTime = new ArrayList<UsuarioTime>();
    }

    public FuncaoTime(long idFuncaoTime, String nome, List<UsuarioTime> usuarioTime) {
        this.idFuncaoTime = idFuncaoTime;
        this.nome = nome;
        this.usuarioTime = usuarioTime;
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

    public List<UsuarioTime> getUsuarioTime() {
        return usuarioTime;
    }

    public void setUsuarioTime(List<UsuarioTime> usuarioTime) {
        this.usuarioTime = usuarioTime;
    }

    @Override
    public String toString() {
        return "FuncaoTime [idFuncaoTime=" + idFuncaoTime + ", nome=" + nome + ", usuarioTime=" + usuarioTime + "]";
    }

}
