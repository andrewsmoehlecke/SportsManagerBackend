package com.api.sportsmanager.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConexaoMysql {

	private String ip;
	private String porta;
	private String login;
	private String senha;
	private String nomeDb;

	private ResultSet resultSet;
	private Statement stat;
	private Connection conexao;

	private static final Logger log = LoggerFactory.getLogger(ConexaoMysql.class);

	public ConexaoMysql() {
		this.ip = "";
		this.porta = "";
		this.login = "";
		this.senha = "";
		this.nomeDb = "";
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
			// this.conexao = DriverManager.getConnection("jdbc:mysql://localhost:",
			// this.login, this.senha);

			this.stat = conexao.createStatement();
			log.info("Connection opened");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void fecharConexao() {
		try {
			if (!this.conexao.isClosed()) {
				this.conexao.close();
				log.info("Connection closed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet getResultSet(String query) {
		try {
			this.resultSet = stat.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
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
