package com.api.sportsmanager.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.api.sportsmanager.entities.Usuario;
import com.api.sportsmanager.persistencia.ConexaoMysql;
import com.api.sportsmanager.util.ConversaoDeData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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
                        rs.getString("senha"),
                        ConversaoDeData.timestampToLocalDateTime(rs.getTimestamp("data_criacao")),
                        rs.getString("foto_perfil"), null);
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

        Usuario u = null;
        // How to take in DB
        try {
            PreparedStatement ps = this.conexao.getConexao().prepareStatement(query);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                u = new Usuario(rs.getLong("id_usuario"), rs.getString("username"), rs.getString("email"),
                        rs.getString("senha"),
                        ConversaoDeData.timestampToLocalDateTime(rs.getTimestamp("data_criacao")),
                        rs.getString("foto_perfil"), null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            conexao.fecharConexao();
        }
        return u;
    }

    public Usuario findByUsername(String username) {
        this.conexao.abrirConexao();

        String query = "SELECT * FROM `usuarios` WHERE username=?";
        // How to take in DB

        Usuario u = null;
        try {
            PreparedStatement ps = this.conexao.getConexao().prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                u = new Usuario(rs.getLong("id_usuario"), rs.getString("username"), rs.getString("email"),
                        rs.getString("senha"),
                        ConversaoDeData.timestampToLocalDateTime(rs.getTimestamp("data_criacao")),
                        rs.getString("foto_perfil"), null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
        return u;
    }

    public Usuario findByEmail(String email) {
        this.conexao.abrirConexao();

        String query = "SELECT * FROM `usuarios` WHERE email=?";

        Usuario u = null;

        // How to take in DB
        try {
            PreparedStatement ps = this.conexao.getConexao().prepareStatement(query);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                u = new Usuario(rs.getLong("id_usuario"), rs.getString("username"), rs.getString("email"),
                        rs.getString("senha"),
                        ConversaoDeData.timestampToLocalDateTime(rs.getTimestamp("data_criacao")),
                        rs.getString("foto_perfil"), null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            conexao.fecharConexao();
        }
        return u;
    }

    public Usuario postUsuario(Usuario u) {
        this.conexao.abrirConexao();
        String query = "INSERT INTO `usuarios` VALUES(null,?,?,?,?,?) ";

        Usuario usuario = null;

        try {
            PreparedStatement st = this.conexao.getConexao().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            st.setString(1, u.getEmail());
            st.setString(2, u.getUsername());
            st.setString(3, u.getSenha());
            st.setTimestamp(4, ConversaoDeData.localDateTimeToTimestamp(u.getDataCriacao()));
            st.setString(5, u.getFotoPerfil());

            st.executeUpdate();

            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                usuario = this.findById(rs.getLong(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
        return usuario;
    }

    public Usuario putUsuario(Usuario u, long idUsuario) {

        this.conexao.abrirConexao();
        String query = "UPDATE `usuarios` SET username=?, email=?, senha=?, foto_perfil=? WHERE id_usuario=?";

        Usuario usuario = null;
        try {
            PreparedStatement st = this.conexao.getConexao().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            st.setString(1, u.getUsername());
            st.setString(2, u.getEmail());
            st.setString(3, u.getSenha());
            st.setString(4, u.getFotoPerfil());
            st.setLong(5, idUsuario);

            st.executeUpdate();

            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                usuario = this.findById(rs.getLong(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }

        return usuario;
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
