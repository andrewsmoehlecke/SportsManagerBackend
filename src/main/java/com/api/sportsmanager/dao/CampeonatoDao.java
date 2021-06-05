package com.api.sportsmanager.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.api.sportsmanager.entities.Campeonato;
import com.api.sportsmanager.persistencia.ConexaoMysql;
import com.api.sportsmanager.util.ConversaoDeData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CampeonatoDao {
    private static final Logger log = LoggerFactory.getLogger(CampeonatoDao.class);

    private ConexaoMysql conexao = new ConexaoMysql();

    public List<Campeonato> findAll() {
        this.conexao.abrirConexao();
        String query = "SELECT * FROM `campeonato`";
        try {
            // List to return results
            List<Campeonato> allCampeonatos = new ArrayList<Campeonato>();

            PreparedStatement ps = this.conexao.getConexao().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            // How to take in DB
            while (rs.next()) {
                TimeDao timeDao = new TimeDao();
                EsporteDao esporteDao = new EsporteDao();

                Campeonato c = new Campeonato(rs.getLong("id_campeonato"), rs.getString("nome"),
                        rs.getString("informacoes"), rs.getString("regras"),
                        ConversaoDeData.dateToLocalDateTime(rs.getDate("data_inicio")),
                        ConversaoDeData.dateToLocalDateTime(rs.getDate("data_final")), rs.getInt("qtd_grupos"),
                        rs.getInt("qtd_times_p_grupo"), rs.getInt("fases_playoffs"),
                        rs.getBoolean("possui_lower_bracket"), timeDao.findById(rs.getLong("campeao")),
                        esporteDao.findById(rs.getLong("id_esporte")), null, null);

                allCampeonatos.add(c);
            }

            return allCampeonatos;
        } catch (SQLException error) {
            error.printStackTrace();
            return null;
        } finally {
            conexao.fecharConexao();
        }
    }

    public Campeonato findById(long id) {
        this.conexao.abrirConexao();

        String query = "SELECT * FROM `campeonato` WHERE id_campeonato=?";

        Campeonato c = null;
        // How to take in DB
        try {
            PreparedStatement ps = this.conexao.getConexao().prepareStatement(query);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                TimeDao timeDao = new TimeDao();
                EsporteDao esporteDao = new EsporteDao();

                c = new Campeonato(rs.getLong("id_campeonato"), rs.getString("nome"), rs.getString("informacoes"),
                        rs.getString("regras"), ConversaoDeData.dateToLocalDateTime(rs.getDate("data_inicio")),
                        ConversaoDeData.dateToLocalDateTime(rs.getDate("data_final")), rs.getInt("qtd_grupos"),
                        rs.getInt("qtd_times_p_grupo"), rs.getInt("fases_playoffs"),
                        rs.getBoolean("possui_lower_bracket"), timeDao.findById(rs.getLong("campeao")),
                        esporteDao.findById(rs.getLong("id_esporte")), null, null);
            }
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
        return c;
    }

    public void postCampeonato(Campeonato c) {

        this.conexao.abrirConexao();
        String query = "INSERT INTO `campeonato` VALUES(null,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = this.conexao.getConexao().prepareStatement(query);

            st.setLong(1, c.getEsporte().getIdEsporte());
            st.setString(2, c.getNome());
            st.setString(3, c.getInformacoes());
            st.setString(4, c.getRegras());
            st.setDate(5, ConversaoDeData.localDateTimeToDate(c.getData_inicio()));
            st.setDate(6, ConversaoDeData.localDateTimeToDate(c.getData_inicio()));
            st.setInt(7, c.getQtdGrupos());
            st.setInt(8, c.getQtdTimesPorGrupo());
            st.setBoolean(9, c.isPossuiLowerBracket());
            st.setInt(10, c.getFasesPlayoffs());
            st.setLong(11, c.getTimeVencedor().getIdTime());

            st.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }

    public void putCampeonato(Campeonato c, long idCampeonato) {

        this.conexao.abrirConexao();
        String query = "UPDATE `campeonato` SET id_esporte=?, nome=?, informacoes=?, regras=?, data_inicio=?, data_final=?, qtd_grupos=?, qtd_times_p_grupo=?, possui_lower_bracket=?, fases_playoffs=?, campeao=? WHERE id_campeonato=?";
        try {
            PreparedStatement st = this.conexao.getConexao().prepareStatement(query);

            st.setLong(1, c.getEsporte().getIdEsporte());
            st.setString(2, c.getNome());
            st.setString(3, c.getInformacoes());
            st.setString(4, c.getRegras());
            st.setDate(5, ConversaoDeData.localDateTimeToDate(c.getData_inicio()));
            st.setDate(6, ConversaoDeData.localDateTimeToDate(c.getData_inicio()));
            st.setInt(7, c.getQtdGrupos());
            st.setInt(8, c.getQtdTimesPorGrupo());
            st.setBoolean(9, c.isPossuiLowerBracket());
            st.setInt(10, c.getFasesPlayoffs());
            st.setLong(11, c.getTimeVencedor().getIdTime());

            st.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }

    public void delete(long id) {
        this.conexao.abrirConexao();
        String query = "DELETE FROM `campeonato` WHERE id_campeonato=?";
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
