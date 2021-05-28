package com.api.sportsmanager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.api.sportsmanager.persistencia.ConexaoMysql;

public class TimeDao {

    private static final Logger log = LoggerFactory.getLogger(TimeDao.class);

    public static void main(String[] args) {

        try {
            ConexaoMysql conexao = new ConexaoMysql("localhost", "3306", "root", "", "sports_manager");
            conexao.abrirConexao();

            ResultSet rs = conexao.getResultSet("SELECT * FROM `time`");
            // How to take in DB
            while (rs.next()) {
                log.info(rs.getLong("id_time") + ", " + rs.getString("nome_time") + ", " + rs.getInt("num_vitoria")
                        + ", " + rs.getInt("num_empate") + ", " + rs.getInt("num_derrota") + ", "
                        + rs.getString("data_criacao"));
            }
            conexao.fecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
