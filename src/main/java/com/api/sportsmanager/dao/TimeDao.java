package com.api.sportsmanager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.api.sportsmanager.entities.Time;
import com.api.sportsmanager.entities.UsuarioTime;
import com.api.sportsmanager.persistencia.ConexaoMysql;

@Service
public class TimeDao {

    private static final Logger log = LoggerFactory.getLogger(TimeDao.class);

    public List<Time> getTime() {

        try {
            
            ConexaoMysql conexao = new ConexaoMysql("localhost", "3306", "root", "", "sports_manager");
            conexao.abrirConexao();

            ResultSet rs = conexao.getResultSet("SELECT * FROM `time`");

            // List to return results
            List<Time> allTimes = new ArrayList<Time>();

            // How to take in DB
            while (rs.next()) {
                        
                Time t = new Time(
                    rs.getLong("id_time"),
                    rs.getString("nome_time"),
                    rs.getInt("num_vitoria"),
                    rs.getInt("num_empate"), 
                    rs.getInt("num_derrota"), 
                    LocalDateTime.parse(rs.getString("data_criacao").replace(" ", "T")),
                    null, 
                    null, 
                    null, 
                    null, 
                    null
                );
                allTimes.add(t);
            }

            conexao.fecharConexao();
            return allTimes;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
