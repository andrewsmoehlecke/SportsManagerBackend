package com.api.sportsmanager.dao;

import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.api.sportsmanager.entities.Esporte;
import com.api.sportsmanager.persistencia.ConexaoMysql;

@Service
public class EsporteDao {
    private static final Logger log = LoggerFactory.getLogger(EsporteDao.class);

    private ConexaoMysql conexao = new ConexaoMysql();

    public List<Esporte> findAll() {
        this.conexao.abrirConexao();
        String query = "SELECT * FROM `esporte`";
        try {
            // List to return results
            List<Esporte> allTimes = new ArrayList<Esporte>();

            PreparedStatement ps = this.conexao.getConexao().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            // How to take in DB
            while (rs.next()) {

                Esporte e = new Esporte(rs.getLong("id_esporte"), rs.getString("nome"), rs.getString("logo"),
                        rs.getString("plataforma"), null, null, null);

                allTimes.add(e);
            }

            return allTimes;
        } catch (SQLException error) {
            error.printStackTrace();
            return null;
        } finally {
            conexao.fecharConexao();
        }
    }

    public Esporte findById(long id) {
        this.conexao.abrirConexao();

        String query = "SELECT * FROM `esportes` WHERE id_esporte=?";

        Esporte e = null;
        // How to take in DB
        try {
            PreparedStatement ps = this.conexao.getConexao().prepareStatement(query);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                e = new Esporte(rs.getLong("id_esporte"), rs.getString("nome"), rs.getString("logo"),
                        rs.getString("plataforma"), null, null, null);
            }
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
        return e;
    }

    public Esporte findByNomeEsporte(String nomeEsporte) {
        this.conexao.abrirConexao();

        String query = "SELECT * FROM `esportes` WHERE nome=?";

        Esporte e = null;
        // How to take in DB
        try {
            PreparedStatement ps = this.conexao.getConexao().prepareStatement(query);
            ps.setString(1, nomeEsporte);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                e = new Esporte(rs.getLong("id_esporte"), rs.getString("nome"), rs.getString("logo"),
                        rs.getString("plataforma"), null, null, null);
            }
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
        return e;
    }

    public void postEsporte(Esporte e) {

        this.conexao.abrirConexao();
        String query = "INSERT INTO `esporte` VALUES(null,?,?,?) ";
        try {
            PreparedStatement st = this.conexao.getConexao().prepareStatement(query);

            st.setString(1, e.getNome());
            st.setString(2, e.getLogo());
            st.setString(3, e.getPlataforma());

            st.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }

    public void putEsporte(Esporte e, long idEsporte) {

        this.conexao.abrirConexao();
        String query = "UPDATE `esporte` SET nome=?, logo=?, plataforma=? WHERE id_esporte=?";
        try {
            PreparedStatement st = this.conexao.getConexao().prepareStatement(query);

            st.setString(1, e.getNome());
            st.setString(2, e.getLogo());
            st.setString(3, e.getPlataforma());
            st.setLong(4, idEsporte);

            st.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }

    public void delete(long id) {
        this.conexao.abrirConexao();
        String query = "DELETE FROM `esporte` WHERE id_esporte=?";
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
