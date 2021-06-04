package com.api.sportsmanager.dao;

import org.springframework.stereotype.Service;

import org.springframework.stereotype.Service;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.api.sportsmanager.entities.CampeonatoTime;
import com.api.sportsmanager.entities.Esporte;
import com.api.sportsmanager.persistencia.ConexaoMysql;
import com.api.sportsmanager.util.ConversaoDeData;

@Service
public class CampeonatoTimeDao {
    private static final Logger log = LoggerFactory.getLogger(CampeonatoTimeDao.class);
    
    private ConexaoMysql conexao = new ConexaoMysql();

    public List<CampeonatoTime> findAll() {
        this.conexao.abrirConexao();
        String query = "SELECT * FROM `campeonato_time`";
        try {
            // List to return results
            List<CampeonatoTime> allCampeonatoTime = new ArrayList<CampeonatoTime>();

            PreparedStatement ps = this.conexao.getConexao().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            // How to take in DB
            while (rs.next()) {
                TimeDao timeDao = new TimeDao();
                CampeonatoDao campeonatoDao = new CampeonatoDao();

                CampeonatoTime ct = new CampeonatoTime(rs.getLong("id_campeonato_time"),
                        campeonatoDao.findById(rs.getLong("id_campeonato")), timeDao.findById(rs.getLong("id_time")));

                allCampeonatoTime.add(ct);
            }

            return allCampeonatoTime;
        } catch (SQLException error) {
            error.printStackTrace();
            return null;
        } finally {
            conexao.fecharConexao();
        }
    }
    
    public CampeonatoTime findById(long id) {
        this.conexao.abrirConexao();

        String query = "SELECT * FROM `campeonato_time` WHERE id_campeonato_time=?";

        CampeonatoTime ct = null;
        // How to take in DB
        try {
            PreparedStatement ps = this.conexao.getConexao().prepareStatement(query);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                TimeDao timeDao = new TimeDao();
                CampeonatoDao campeonatoDao = new CampeonatoDao();

                ct = new CampeonatoTime(rs.getLong("id_campeonato_time"),
                        campeonatoDao.findById(rs.getLong("id_campeonato")), timeDao.findById(rs.getLong("id_time")));
            }
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
        return ct;
    }

    public void postCampeonatoTime(CampeonatoTime ct) {

        this.conexao.abrirConexao();
        String query = "INSERT INTO `campeonato_time` VALUES(null,?,?)";
        try {
            PreparedStatement st = this.conexao.getConexao().prepareStatement(query);

            st.setLong(1, ct.getCampeonato().getIdCampeonato());
            st.setLong(2, ct.getTime().getIdTime());

            st.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }
    
    public void putCampeonatoTime(CampeonatoTime ct, long idCampeonatoTime) {

        this.conexao.abrirConexao();
        String query = "UPDATE `campeonato_time` SET id_campeonato=?, id_time=? WHERE id_campeonato_time=?";
        try {
            PreparedStatement st = this.conexao.getConexao().prepareStatement(query);

            st.setLong(1, ct.getCampeonato().getIdCampeonato());
            st.setLong(2, ct.getTime().getIdTime());

            st.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }

    public void delete(long id) {
        this.conexao.abrirConexao();
        String query = "DELETE FROM `campeonato_time` WHERE id_campeonato_time=?";
        try {
            PreparedStatement st = this.conexao.getConexao().prepareStatement(query);
            st.setLong(1, id);

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }
}
