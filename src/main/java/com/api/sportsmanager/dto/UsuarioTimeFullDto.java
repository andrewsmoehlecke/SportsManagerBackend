package com.api.sportsmanager.dto;

import java.time.LocalDateTime;

public class UsuarioTimeFullDto {
    private long idUsuarioTime;
    private LocalDateTime dataEntrada;
    private String cargo;
    private UsuarioDto usuario;
    private TimeDto time;
    private FuncaoTimeDto funcaoTime;

    public UsuarioTimeFullDto() {
        this.idUsuarioTime = 0;
        this.dataEntrada = LocalDateTime.now();
        this.cargo = "";
        this.usuario = new UsuarioDto();
        this.time = new TimeDto();
        this.funcaoTime = new FuncaoTimeDto();
    }

    public UsuarioTimeFullDto(long idUsuarioTime, LocalDateTime dataEntrada, String cargo, UsuarioDto usuario,
            TimeDto time, FuncaoTimeDto funcaoTime) {
        this.idUsuarioTime = idUsuarioTime;
        this.dataEntrada = dataEntrada;
        this.cargo = cargo;
        this.usuario = usuario;
        this.time = time;
        this.funcaoTime = funcaoTime;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public UsuarioDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDto usuario) {
        this.usuario = usuario;
    }

    public TimeDto getTime() {
        return time;
    }

    public void setTime(TimeDto time) {
        this.time = time;
    }

    public FuncaoTimeDto getFuncaoTime() {
        return funcaoTime;
    }

    public void setFuncaoTime(FuncaoTimeDto funcaoTime) {
        this.funcaoTime = funcaoTime;
    }

    @Override
    public String toString() {
        return "UsuarioTimeFullDto [cargo=" + cargo + ", dataEntrada=" + dataEntrada + ", funcaoTime=" + funcaoTime
                + ", idUsuarioTime=" + idUsuarioTime + ", time=" + time + ", usuario=" + usuario + "]";
    }
}
