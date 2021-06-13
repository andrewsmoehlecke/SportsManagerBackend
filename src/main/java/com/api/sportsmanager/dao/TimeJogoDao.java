package com.api.sportsmanager.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.api.sportsmanager.entities.TimeJogo;
import com.api.sportsmanager.persistencia.ConexaoMysql;
import com.api.sportsmanager.util.ConversaoDeData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TimeJogoDao {
    private static final Logger log = LoggerFactory.getLogger(TimeJogoDao.class);

    private ConexaoMysql conexao = new ConexaoMysql();

    public List<TimeJogo> findAll() {
        this.conexao.abrirConexao();
        String query = "SELECT * FROM `time_jogos`";
        List<TimeJogo> allTimeJogo = new ArrayList<TimeJogo>();
        try {
            PreparedStatement ps = this.conexao.getConexao().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            // How to take in DB
            while (rs.next()) {
                TimeDao timeDao = new TimeDao();

                TimeJogo tj = new TimeJogo(rs.getLong("id_time_jogos"), rs.getString("local"),
                        rs.getInt("pontuacao_time_1"), rs.getInt("pontuacao_time_2"),
                        ConversaoDeData.timestampToLocalDateTime(rs.getTimestamp("data_jogo")),
                        timeDao.findById(rs.getLong("id_time_1")), timeDao.findById(rs.getLong("id_time_2")),
                        rs.getString("titulo"));

                allTimeJogo.add(tj);
            }

        } catch (SQLException error) {
            error.printStackTrace();
            return null;
        } finally {
            conexao.fecharConexao();
        }
        return allTimeJogo;
    }

    public TimeJogo findById(long id) {
        this.conexao.abrirConexao();

        String query = "SELECT * FROM `time_jogos` WHERE id_time_jogos=?";

        TimeJogo tj = null;
        // How to take in DB
        try {
            PreparedStatement ps = this.conexao.getConexao().prepareStatement(query);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                TimeDao timeDao = new TimeDao();

                tj = new TimeJogo(rs.getLong("id_time_jogos"), rs.getString("local"), rs.getInt("pontuacao_time_1"),
                        rs.getInt("pontuacao_time_2"),
                        ConversaoDeData.timestampToLocalDateTime(rs.getTimestamp("data_jogo")),
                        timeDao.findById(rs.getLong("id_time_1")), timeDao.findById(rs.getLong("id_time_2")),
                        rs.getString("titulo"));
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
        String query = "INSERT INTO `time_jogos` VALUES(null,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = this.conexao.getConexao().prepareStatement(query);

            st.setString(1, tj.getLocal());
            st.setInt(2, tj.getPontuacaoTime1());
            st.setInt(3, tj.getPontuacaoTime2());
            st.setTimestamp(4, ConversaoDeData.localDateTimeToTimestamp(tj.getDataJogo()));
            st.setLong(5, tj.getTime1().getIdTime());
            st.setLong(6, tj.getTime2().getIdTime());
            st.setString(7, tj.getTitulo());

            st.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }

    public void putTimeJogo(TimeJogo tj, long idTimeJogo) {

        this.conexao.abrirConexao();
        String query = "UPDATE `time_jogos` SET local=?, pontuacao_time_1=?, pontuacao_time_2=?, data_jogo=?, id_time_1=?, id_time_2=?, titulo=? WHERE id_time_jogo=?";
        try {
            PreparedStatement st = this.conexao.getConexao().prepareStatement(query);

            st.setString(1, tj.getLocal());
            st.setInt(2, tj.getPontuacaoTime1());
            st.setInt(3, tj.getPontuacaoTime2());
            st.setTimestamp(4, ConversaoDeData.localDateTimeToTimestamp(tj.getDataJogo()));
            st.setLong(5, tj.getTime1().getIdTime());
            st.setLong(6, tj.getTime2().getIdTime());
            st.setString(7, tj.getTitulo());

            st.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }

    public void delete(long id) {
        this.conexao.abrirConexao();
        String query = "DELETE FROM `time_jogos` WHERE id_time_jogo=?";
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
