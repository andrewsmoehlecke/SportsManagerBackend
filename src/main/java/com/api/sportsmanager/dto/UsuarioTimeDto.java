package com.api.sportsmanager.dto;

import java.time.LocalDateTime;

public class UsuarioTimeDto {
    private long idUsuarioTime;
    private LocalDateTime dataEntrada;
    private String cargo;
    private long idUsuario;
    private long idTime;
    private long idFuncaoTime;

    public UsuarioTimeDto() {
        this.idUsuarioTime = 0;
        this.dataEntrada = LocalDateTime.now();
        this.cargo = "";
        this.idUsuario = 0;
        this.idTime = 0;
        this.idFuncaoTime = 0;
    }

    public UsuarioTimeDto(long idUsuarioTime, LocalDateTime dataEntrada, String cargo, long idUsuario, long idTime,
            long idFuncaoTime) {
        this.idUsuarioTime = idUsuarioTime;
        this.dataEntrada = dataEntrada;
        this.cargo = "";
        this.idUsuario = 0;
        this.idTime = 0;
        this.idFuncaoTime = 0;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public long getIdUsuarioTime() {
        return idUsuarioTime;
    }

    public void setIdUsuarioTime(long idUsuarioTime) {
        this.idUsuarioTime = idUsuarioTime;
    }

    public LocalDateTime getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDateTime dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public long getIdTime() {
        return idTime;
    }

    public void setIdTime(long idTime) {
        this.idTime = idTime;
    }

    public long getIdFuncaoTime() {
        return idFuncaoTime;
    }

    public void setIdFuncaoTime(long idFuncaoTime) {
        this.idFuncaoTime = idFuncaoTime;
    }

}
