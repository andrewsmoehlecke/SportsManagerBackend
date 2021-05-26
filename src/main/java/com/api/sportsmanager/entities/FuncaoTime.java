package com.api.sportsmanager.entities;
import java.util.ArrayList;
import java.util.List;

public class FuncaoTime {
    private long idFuncaoTime;
    private String nome;
    private Esporte esporte;
    private List<UsuarioTime> usuarioTime;

    public FuncaoTime() {
        this.idFuncaoTime = 0;
        this.nome = "";
        this.esporte = new Esporte();
        this.usuarioTime = new ArrayList<UsuarioTime>();
    }

    public FuncaoTime(long idFuncaoTime, String nome, Esporte esporte, List<UsuarioTime> usuarioTime) {
        this.idFuncaoTime = idFuncaoTime;
        this.nome = nome;
        this.esporte = esporte;
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

    public Esporte getEsporte() {
        return esporte;
    }

    public void setEsporte(Esporte esporte) {
        this.esporte = esporte;
    }

    public List<UsuarioTime> getUsuarioTime() {
        return usuarioTime;
    }

    public void setUsuarioTime(List<UsuarioTime> usuarioTime) {
        this.usuarioTime = usuarioTime;
    }

    @Override
    public String toString() {
        return "FuncaoTime [idFuncaoTime=" + idFuncaoTime + ", nome=" + nome + ", esporte=" + esporte + ", usuarioTime="
                + usuarioTime + "]";
    }

}
