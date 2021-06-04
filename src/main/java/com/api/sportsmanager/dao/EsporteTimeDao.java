package com.api.sportsmanager.dao;

import org.springframework.stereotype.Service;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.api.sportsmanager.entities.Campeonato;
import com.api.sportsmanager.entities.Esporte;
import com.api.sportsmanager.entities.EsporteTime;
import com.api.sportsmanager.persistencia.ConexaoMysql;
import com.api.sportsmanager.util.ConversaoDeData;

@Service
public class EsporteTimeDao {
    private static final Logger log = LoggerFactory.getLogger(EsporteTimeDao.class);
    
    private ConexaoMysql conexao = new ConexaoMysql();

    public List<EsporteTime> findAll() {
        this.conexao.abrirConexao();
        String query = "SELECT * FROM `esporte_time`";
        try {
            // List to return results
            List<EsporteTime> allEsporteTime = new ArrayList<EsporteTime>();

            PreparedStatement ps = this.conexao.getConexao().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            // How to take in DB
            while (rs.next()) {
                TimeDao timeDao = new TimeDao();
                EsporteDao esporteDao = new EsporteDao();

                EsporteTime et = new EsporteTime(rs.getLong("id_esporte_time"),
                        esporteDao.findById(rs.getLong("id_esporte")), timeDao.findById(rs.getLong("id_time")));

                allEsporteTime.add(et);
            }

            return allEsporteTime;
        } catch (SQLException error) {
            error.printStackTrace();
            return null;
        } finally {
            conexao.fecharConexao();
        }
    }
    
    public EsporteTime findById(long id) {
        this.conexao.abrirConexao();

        String query = "SELECT * FROM `esporte_time` WHERE id_esporte_time=?";

        EsporteTime et = null;
        // How to take in DB
        try {
            PreparedStatement ps = this.conexao.getConexao().prepareStatement(query);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                TimeDao timeDao = new TimeDao();
                EsporteDao esporteDao = new EsporteDao();

                et = new EsporteTime(rs.getLong("id_esporte_time"), esporteDao.findById(rs.getLong("id_esporte")),
                        timeDao.findById(rs.getLong("id_time")));
            }
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
        return et;
    }
    
    public void postEsporteTime(EsporteTime et) {

        this.conexao.abrirConexao();
        String query = "INSERT INTO `esporte_time` VALUES(null,?,?)";
        try {
            PreparedStatement st = this.conexao.getConexao().prepareStatement(query);

            st.setLong(1, et.getTime().getIdTime());
            st.setLong(2, et.getEsporte().getIdEsporte());

            st.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }

    public void putEsporteTime(EsporteTime et, long idEsporteTime) {

        this.conexao.abrirConexao();
        String query = "UPDATE `esporte_time` SET id_time=?, id_esporte=? WHERE id_esporte_time=?";
        try {
            PreparedStatement st = this.conexao.getConexao().prepareStatement(query);

            st.setLong(1, et.getTime().getIdTime());
            st.setLong(2, et.getEsporte().getIdEsporte());
            st.setLong(3, idEsporteTime);

            st.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }

    public void delete(long id) {
        this.conexao.abrirConexao();
        String query = "DELETE FROM `esporte_time` WHERE id_esporte_time=?";
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
