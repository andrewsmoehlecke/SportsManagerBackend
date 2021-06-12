package com.api.sportsmanager.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.api.sportsmanager.entities.FuncaoTime;
import com.api.sportsmanager.persistencia.ConexaoMysql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FuncaoTimeDao {
    private static final Logger log = LoggerFactory.getLogger(FuncaoTimeDao.class);

    private ConexaoMysql conexao = new ConexaoMysql();

    public List<FuncaoTime> findAll() {
        this.conexao.abrirConexao();
        String query = "SELECT * FROM `funcao_time`";
        try {
            // List to return results
            List<FuncaoTime> listFuncaoTime = new ArrayList<FuncaoTime>();

            PreparedStatement ps = this.conexao.getConexao().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            // How to take in DB
            while (rs.next()) {
                EsporteDao esporteDao = new EsporteDao();

                FuncaoTime ft = new FuncaoTime(rs.getLong("id_funcao_time"), rs.getString("nome"),
                        esporteDao.findById(rs.getLong("id_esporte")), null);
                listFuncaoTime.add(ft);
            }

            return listFuncaoTime;
        } catch (SQLException error) {
            error.printStackTrace();
            return null;
        } finally {
            conexao.fecharConexao();
        }
    }

    public FuncaoTime findById(long id) {
        this.conexao.abrirConexao();

        String query = "SELECT * FROM `funcao_time` WHERE id_funcao_time=?";

        FuncaoTime ft = null;
        // How to take in DB
        try {
            PreparedStatement ps = this.conexao.getConexao().prepareStatement(query);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                EsporteDao esporteDao = new EsporteDao();

                ft = new FuncaoTime(rs.getLong("id_funcao_time"), rs.getString("nome"),
                        esporteDao.findById(rs.getLong("id_esporte")), null);
            }
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
        return ft;
    }

    public void postFuncaoTime(FuncaoTime ft) {

        this.conexao.abrirConexao();
        String query = "INSERT INTO `funcao_time` VALUES(null,?,?)";
        try {
            PreparedStatement st = this.conexao.getConexao().prepareStatement(query);

            st.setString(1, ft.getNome());
            st.setLong(2, ft.getEsporte().getIdEsporte());

            st.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }

    public void putFuncaoTime(FuncaoTime ft, long idFuncaoTime) {

        this.conexao.abrirConexao();
        String query = "UPDATE `funcao_time` SET nome=?, id_esporte=? WHERE id_funcao_time=?";
        try {
            PreparedStatement st = this.conexao.getConexao().prepareStatement(query);

            st.setString(1, ft.getNome());
            st.setLong(2, ft.getEsporte().getIdEsporte());

            st.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }

    public void delete(long id) {
        this.conexao.abrirConexao();
        String query = "DELETE FROM `funcao_time` WHERE id_funcao_time=?";
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
