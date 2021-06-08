package com.api.sportsmanager.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private long idUsuario;
    private String username;
    private String email;
    private String senha;
    private LocalDateTime dataCriacao;
    private String fotoPerfil;
    private List<UsuarioTime> usuarioTime;

    public Usuario() {
        this.idUsuario = 0;
        this.username = "";
        this.email = "";
        this.senha = "";
        this.dataCriacao = LocalDateTime.now();
        this.setFotoPerfil(null);
        this.setUsuarioTime(new ArrayList<UsuarioTime>());
    }

    public Usuario(long idUsuario, String username, String email, String senha, LocalDateTime dataCriacao,
            String fotoPerfil, List<UsuarioTime> usuarioTime) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.email = email;
        this.senha = senha;
        this.dataCriacao = dataCriacao;
        this.setFotoPerfil(fotoPerfil);
        this.setUsuarioTime(usuarioTime);
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public List<UsuarioTime> getUsuarioTime() {
        return usuarioTime;
    }

    public void setUsuarioTime(List<UsuarioTime> usuarioTime) {
        this.usuarioTime = usuarioTime;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public String toString() {
        return "Usuario [dataCriacao=" + dataCriacao + ", email=" + email + ", idUsuario=" + idUsuario + ", senha="
                + senha + ", username=" + username + "]";
    }

}
