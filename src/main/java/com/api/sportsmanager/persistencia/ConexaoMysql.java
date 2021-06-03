package com.api.sportsmanager.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConexaoMysql {

	private String ip;
	private String porta;
	private String login;
	private String senha;
	private String nomeDb;

	private Connection conexao;

	private static final Logger log = LoggerFactory.getLogger(ConexaoMysql.class);

	public ConexaoMysql() {
		this.ip = "localhost";
		this.porta = "3306";
		this.login = "root";
		this.senha = "";
		this.nomeDb = "sports_manager";
	}

	public ConexaoMysql(String ip, String porta, String login, String senha, String nomeDb) {
		this.ip = ip;
		this.porta = porta;
		this.login = login;
		this.senha = senha;
		this.nomeDb = nomeDb;
	}

	public void abrirConexao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String endereco = "jdbc:mysql://" + this.ip + ":" + this.porta + "/" + this.nomeDb;

			this.conexao = DriverManager.getConnection(endereco, this.login, this.senha);
			
			log.info("Connection opened");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void fecharConexao() {
		try {
			if (this.conexao != null && !this.conexao.isClosed()) {
				this.conexao.close();
				log.info("Connection closed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConexao() {
		return this.conexao;
	}

	public void isClosed() {
		try {
			if (!this.conexao.isClosed()) {
				log.info("Connection estabilished");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
