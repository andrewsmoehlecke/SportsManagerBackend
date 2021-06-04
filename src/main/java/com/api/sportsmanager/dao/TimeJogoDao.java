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

import com.api.sportsmanager.entities.Campeonato;
import com.api.sportsmanager.entities.Esporte;
import com.api.sportsmanager.entities.TimeJogo;
import com.api.sportsmanager.persistencia.ConexaoMysql;
import com.api.sportsmanager.util.ConversaoDeData;

@Service
public class TimeJogoDao {
    private static final Logger log = LoggerFactory.getLogger(EsporteDao.class);
    
    private ConexaoMysql conexao = new ConexaoMysql();

    public List<TimeJogo> findAll() {
        this.conexao.abrirConexao();
        String query = "SELECT * FROM `time_jogos`";
        try {
            // List to return results
            List<TimeJogo> allTimeJogo = new ArrayList<TimeJogo>();

            PreparedStatement ps = this.conexao.getConexao().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            // How to take in DB
            while (rs.next()) {
                TimeDao timeDao = new TimeDao();
                JogoDao jogoDao = new JogoDao();

                TimeJogo tj = new TimeJogo(rs.getLong("id_time_jogos"), rs.getString("local"),
                        rs.getInt("pontuacao_time_1"), rs.getInt("pontuacao_time_2"),
                        ConversaoDeData.dateToLocalDateTime(rs.getDate("data_jogo")),
                        timeDao.findById(rs.getLong("id_time")), jogoDao.findById(rs.getLong("id_jogo")));

                allTimeJogo.add(tj);
            }

            return allTimeJogo;
        } catch (SQLException error) {
            error.printStackTrace();
            return null;
        } finally {
            conexao.fecharConexao();
        }
    }
    
    public TimeJogo findById(long id) {
        this.conexao.abrirConexao();

        String query = "SELECT * FROM `time_jogo` WHERE id_time_jogo=?";

        TimeJogo tj = null;
        // How to take in DB
        try {
            PreparedStatement ps = this.conexao.getConexao().prepareStatement(query);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                TimeDao timeDao = new TimeDao();
                JogoDao jogoDao = new JogoDao();

                tj = new TimeJogo(rs.getLong("id_time_jogos"), rs.getString("local"), rs.getInt("pontuacao_time_1"),
                        rs.getInt("pontuacao_time_2"), ConversaoDeData.dateToLocalDateTime(rs.getDate("data_jogo")),
                        timeDao.findById(rs.getLong("id_time")), jogoDao.findById(rs.getLong("id_jogo")));
            }
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
        return tj;
    }
    
    public void postTimeJogo(TimeJogo tj) {

        this.conexao.abrirConexao();
        String query = "INSERT INTO `time_jogo` VALUES(null,?,?,?,?,?,?)";
        try {
            PreparedStatement st = this.conexao.getConexao().prepareStatement(query);

            st.setString(1, tj.getLocal());
            st.setInt(2, tj.getPontuacaoTime1());
            st.setInt(3, tj.getPontuacaoTime2());
            st.setDate(4, ConversaoDeData.localDateTimeToDate(tj.getDataJogo()));
            st.setLong(5, tj.getTime().getIdTime());
            st.setLong(6, tj.getJogo().getIdJogo());

            st.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }

    public void putTimeJogo(TimeJogo tj, long idTimeJogo) {

        this.conexao.abrirConexao();
        String query = "UPDATE `campeonato` SET local=?, pontuacao_time_1=?, pontuacao_time_2=?, data_jogo=?, id_time=?,  WHERE id_campeonato=?";
        try {
            PreparedStatement st = this.conexao.getConexao().prepareStatement(query);

            st.setString(1, tj.getLocal());
            st.setInt(2, tj.getPontuacaoTime1());
            st.setInt(3, tj.getPontuacaoTime2());
            st.setDate(4, ConversaoDeData.localDateTimeToDate(tj.getDataJogo()));
            st.setLong(5, tj.getTime().getIdTime());
            st.setLong(6, tj.getJogo().getIdJogo());

            st.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }

    public void delete(long id) {
        this.conexao.abrirConexao();
        String query = "DELETE FROM `time_jogo` WHERE id_time_jogo=?";
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
