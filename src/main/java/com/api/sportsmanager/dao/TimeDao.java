package com.api.sportsmanager.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.sportsmanager.entities.Time;
import com.api.sportsmanager.persistencia.ConexaoMysql;
import com.api.sportsmanager.util.ConversaoDeData;

@Service
public class TimeDao {

    private static final Logger log = LoggerFactory.getLogger(TimeDao.class);
    
    private ConexaoMysql conexao = new ConexaoMysql();

  
    private ConversaoDeData convert;

    public TimeDao(ConversaoDeData c) {
        this.convert = c;
    }

    public List<Time> findAll() {

        this.conexao.abrirConexao();
        String query = "SELECT * FROM `time`";
        try {
            // List to return results
            List<Time> allTimes = new ArrayList<Time>();

            PreparedStatement ps = this.conexao.getConexao().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

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

            return allTimes;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            conexao.fecharConexao();
        }
    }
    
    public Time findById(long id) {
        ConexaoMysql conexao = new ConexaoMysql();
        this.conexao.abrirConexao();

        String query = "SELECT * FROM `time` WHERE id_time=?";
        // How to take in DB
        try {
            PreparedStatement ps = this.conexao.getConexao().prepareStatement(query);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            Time t = new Time();
            if (rs.next()) {

                t = new Time(
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
            }
            return t;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            conexao.fecharConexao();
        }
    }
    
    public void postTime(Time time) {

        this.conexao.abrirConexao();
        String query = "INSERT INTO `time` VALUES(null,?,?,?,?,?) ";
        try {
            PreparedStatement st = this.conexao.getConexao().prepareStatement(query);
            Date dt = convert.localDateTimeToDate(time.getDataCriacao());

            st.setString(1, time.getNomeTime());
            st.setInt(2, time.getNumVitoria());
            st.setInt(3, time.getNumEmpate());
            st.setInt(4, time.getNumDerrota());
            st.setDate(5, dt);

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }
    
    public void putTime(Time time, long idTime) {
        
        this.conexao.abrirConexao();
        String query = "INSERT INTO `time` VALUES(null,?,?,?,?,?) WHERE id_time=?";
        try {
            PreparedStatement st = this.conexao.getConexao().prepareStatement(query);
            Date dt = convert.localDateTimeToDate(time.getDataCriacao());

            st.setString(1, time.getNomeTime());
            st.setInt(2, time.getNumVitoria());
            st.setInt(3, time.getNumEmpate());
            st.setInt(4, time.getNumDerrota());
            st.setDate(5, dt);
            st.setLong(6, idTime);

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }
}
