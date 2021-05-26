package com.api.sportsmanager.entities;
import java.time.LocalDate;

public class UsuarioTime {
    private long idUsuarioTime;
    private LocalDate dataEntrada;
    private Usuario usuario;
    private Time time;
    private String cargo;
    private FuncaoTime funcaoTime;

    public UsuarioTime() {
        this.idUsuarioTime = 0;
        this.dataEntrada = LocalDate.now();
        this.usuario = new Usuario();
        this.time = new Time();
        this.cargo = "";
        this.funcaoTime = new FuncaoTime();
    }

    public UsuarioTime(long idUsuarioTime, LocalDate dataEntrada, Usuario usuario, Time time, String cargo, FuncaoTime funcaoTime) {
        this.idUsuarioTime = idUsuarioTime;
        this.dataEntrada = dataEntrada;
        this.usuario = usuario;
        this.time = time;
        this.cargo = "";
        this.funcaoTime = funcaoTime;
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

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }


	public FuncaoTime getFuncaoTime() {
		return funcaoTime;
	}

	public void setFuncaoTime(FuncaoTime funcaoTime) {
		this.funcaoTime = funcaoTime;
	}

	@Override
	public String toString() {
		return "UsuarioTime [idUsuarioTime=" + idUsuarioTime + ", dataEntrada=" + dataEntrada + ", usuario=" + usuario
				+ ", time=" + time + ", cargo=" + cargo + ", funcaoTime=" + funcaoTime + "]";
	}

}
