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
import com.api.sportsmanager.entities.Jogo;
import com.api.sportsmanager.persistencia.ConexaoMysql;

@Service
public class JogoDao {
    private static final Logger log = LoggerFactory.getLogger(JogoDao.class);
    
    private ConexaoMysql conexao = new ConexaoMysql();

    public List<Jogo> findAll() {
        this.conexao.abrirConexao();
        String query = "SELECT * FROM `jogos`";

        // List to return results
        List<Jogo> allJogos = new ArrayList<Jogo>();
        try {

            PreparedStatement ps = this.conexao.getConexao().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            // How to take in DB
            while (rs.next()) {
                CampeonatoDao dao = new CampeonatoDao();

                Jogo j = new Jogo(
                    rs.getLong("id_jogo"),
                    rs.getInt("pontuacao_time_1"),
                    rs.getInt("pontuacao_time_2"),
                    null,
                    dao.findById(rs.getLong("id_campeonato"))
                );

                allJogos.add(j);
            }
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
        return allJogos;
    }
    
    public Jogo findById(long id) {
        this.conexao.abrirConexao();

        String query = "SELECT * FROM `jogos` WHERE id_jogo=?";

        Jogo j = null;
        // How to take in DB
        try {
            PreparedStatement ps = this.conexao.getConexao().prepareStatement(query);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                CampeonatoDao dao = new CampeonatoDao();

                j = new Jogo(rs.getLong("id_jogo"), rs.getInt("pontuacao_time_1"), rs.getInt("pontuacao_time_2"), null,
                        dao.findById(rs.getLong("id_campeonato")));
            }
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
        return j;
    }
    
    public void postJogo(Jogo j) {

        this.conexao.abrirConexao();
        String query = "INSERT INTO `jogos` VALUES(null,?,?,?)";
        try {
            PreparedStatement st = this.conexao.getConexao().prepareStatement(query);

            st.setInt(1, j.getPontuacaoTime1());
            st.setInt(1, j.getPontuacaoTime2());
            st.setLong(3, j.getCampeonato().getIdCampeonato());
            
            st.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }

    public void putJogo(Jogo j, long idEsporte) {

        this.conexao.abrirConexao();
        String query = "UPDATE `jogos` SET pontuacao_time_1=?, pontuacao_time_2=?, id_campeonato=?  WHERE id_jogo=?";
        try {
            PreparedStatement st = this.conexao.getConexao().prepareStatement(query);

            st.setInt(1, j.getPontuacaoTime1());
            st.setInt(1, j.getPontuacaoTime2());
            st.setLong(3, j.getCampeonato().getIdCampeonato());

            st.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }


    public void delete(long id) {
        this.conexao.abrirConexao();
        String query = "DELETE FROM `jogos` WHERE id_jogo=?";
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
