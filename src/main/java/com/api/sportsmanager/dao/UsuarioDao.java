package com.api.sportsmanager.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.api.sportsmanager.entities.Usuario;
import com.api.sportsmanager.persistencia.ConexaoMysql;
import com.api.sportsmanager.util.ConversaoDeData;

@Service
public class UsuarioDao {
    private static final Logger log = LoggerFactory.getLogger(UsuarioDao.class);

    private ConexaoMysql conexao = new ConexaoMysql();

    public List<Usuario> findAll() {
        this.conexao.abrirConexao();
        String query = "SELECT * FROM `usuarios`";
        try {
            // List to return results
            List<Usuario> allTimes = new ArrayList<Usuario>();

            PreparedStatement ps = this.conexao.getConexao().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            // How to take in DB
            while (rs.next()) {

                Usuario u = new Usuario(rs.getLong("id_usuario"), rs.getString("username"), rs.getString("email"),
                        rs.getString("senha"), ConversaoDeData.dateToLocalDateTime(rs.getDate("data_criacao")), null);
                allTimes.add(u);
            }

            return allTimes;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            conexao.fecharConexao();
        }
    }

    public Usuario findById(long id) {
        this.conexao.abrirConexao();

        String query = "SELECT * FROM `usuarios` WHERE id_usuario=?";
        // How to take in DB
        try {
            PreparedStatement ps = this.conexao.getConexao().prepareStatement(query);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            Usuario u = new Usuario();
            if (rs.next()) {

                u = new Usuario(rs.getLong("id_usuario"), rs.getString("username"), rs.getString("email"),
                        rs.getString("senha"), ConversaoDeData.dateToLocalDateTime(rs.getDate("data_criacao")), null);
            }
            return u;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            conexao.fecharConexao();
        }
    }

    public Usuario findByUsername(String username) {
        this.conexao.abrirConexao();

        String query = "SELECT * FROM `usuarios` WHERE username=?";
        // How to take in DB
        try {
            PreparedStatement ps = this.conexao.getConexao().prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            Usuario u = new Usuario();
            if (rs.next()) {

                u = new Usuario(rs.getLong("id_usuario"), rs.getString("username"), rs.getString("email"),
                        rs.getString("senha"), ConversaoDeData.dateToLocalDateTime(rs.getDate("data_criacao")), null);
            }
            return u;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            conexao.fecharConexao();
        }
    }

    public void postUsuario(Usuario u) {

        this.conexao.abrirConexao();
        String query = "INSERT INTO `usuarios` VALUES(null,?,?,?,?) ";
        try {
            PreparedStatement st = this.conexao.getConexao().prepareStatement(query);
            Date dt = ConversaoDeData.localDateTimeToDate(u.getDataCriacao());

            st.setString(1, u.getUsername());
            st.setString(2, u.getEmail());
            st.setString(3, u.getSenha());
            st.setDate(4, dt);

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }

    public void putUsuario(Usuario u, long idUsuario) {

        this.conexao.abrirConexao();
        String query = "UPDATE `usuarios` SET username=?, email=?, senha=?, data_criacao=? WHERE id_usuario=?";
        try {
            PreparedStatement st = this.conexao.getConexao().prepareStatement(query);
            // Convert from LocalDateTime to Date
            Date dt = ConversaoDeData.localDateTimeToDate(u.getDataCriacao());

            st.setString(1, u.getUsername());
            st.setString(2, u.getEmail());
            st.setString(3, u.getSenha());
            st.setDate(4, dt);
            st.setLong(5, idUsuario);

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }

    public void delete(long id) {
        this.conexao.abrirConexao();
        String query = "DELETE FROM `usuarios` WHERE id_usuario=?";
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