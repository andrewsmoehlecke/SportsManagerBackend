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
    private static final Logger log = LoggerFactory.getLogger(EsporteDao.class);
    
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

                // https://www.youtube.com/watch?v=JW9w1nI6Q3g  2:04:56
                // Campeonato c ;
                // Jogo j = new Jogo(
                //     rs.getLong("id_jogo"),
                //     rs.getInt("pontuacao_time_1"),
                //     rs.getInt("pontuacao_time_2"),
                //     rs.getLong("id_campeonato"),
                //     null
                // );

                // allJogos.add(j);
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

                 // https://www.youtube.com/watch?v=JW9w1nI6Q3g  2:04:56
                // Campeonato c ;
                // Jogo j = new Jogo(
                //     rs.getLong("id_jogo"),
                //     rs.getInt("pontuacao_time_1"),
                //     rs.getInt("pontuacao_time_2"),
                //     rs.getLong("id_campeonato"),
                //     null
                // );
            }
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
        return j;
    }
}
