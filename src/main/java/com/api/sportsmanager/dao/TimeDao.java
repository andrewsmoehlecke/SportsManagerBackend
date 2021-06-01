package com.api.sportsmanager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.api.sportsmanager.entities.Time;
import com.api.sportsmanager.persistencia.ConexaoMysql;

@Service
public class TimeDao {

    private static final Logger log = LoggerFactory.getLogger(TimeDao.class);

    public List<Time> getTime() {

        ConexaoMysql conexao = new ConexaoMysql();
        conexao.abrirConexao();
        try {

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
                    LocalDateTime.parse(
                        rs.getString("data_criacao").replace(" ", "T")
                    ), 
                    null, 
                    null, 
                    null, 
                    null,
                    null
                );
                allTimes.add(t);
            }

            return allTimes;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            conexao.fecharConexao();
        }
    }
    
    public Time getTimeById(long id) {
        ConexaoMysql conexao = new ConexaoMysql();
        conexao.abrirConexao();

        // How to take in DB
        try {
            ResultSet rs = conexao.getResultSet("SELECT * FROM `time` WHERE id_time="+id);

            Time t = new Time();
            while (rs.next()){
    
                t = new Time(
                    rs.getLong("id_time"),
                    rs.getString("nome_time"),
                    rs.getInt("num_vitoria"),
                    rs.getInt("num_empate"),
                    rs.getInt("num_derrota"),
                    LocalDateTime.parse(
                        rs.getString("data_criacao").replace(" ", "T")
                    ), 
                    null, 
                    null, 
                    null, 
                    null, 
                    null
                );
            }
            log.info(t.toString());
            return t;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            conexao.fecharConexao();
        }
    }
}
