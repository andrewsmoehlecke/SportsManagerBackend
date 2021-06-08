package com.api.sportsmanager.dto;

import java.time.LocalDateTime;

public class UsuarioDto {
    private long idUsuario;
    private String username;
    private String email;
    private String senha;
    private LocalDateTime dataCriacao;
    private String fotoPerfil;

    public UsuarioDto() {
        this.idUsuario = 0;
        this.username = "";
        this.email = "";
        this.senha = "";
        this.dataCriacao = LocalDateTime.now();
        this.setFotoPerfil(null);
    }

    public UsuarioDto(long idUsuario, String username, String email, String senha, LocalDateTime dataCriacao,
            String fotoPerfil) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.email = email;
        this.senha = senha;
        this.dataCriacao = dataCriacao;
        this.fotoPerfil = fotoPerfil;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
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
}
