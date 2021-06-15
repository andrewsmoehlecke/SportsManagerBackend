package com.api.sportsmanager.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.api.sportsmanager.dto.UsuarioTimeFullDto;
import com.api.sportsmanager.entities.UsuarioTime;
import com.api.sportsmanager.persistencia.ConexaoMysql;
import com.api.sportsmanager.util.ConversaoDeData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UsuarioTimeDao {
    private static final Logger log = LoggerFactory.getLogger(UsuarioTimeDao.class);

    private ConexaoMysql conexao = new ConexaoMysql();

    public List<UsuarioTime> findAll() {
        this.conexao.abrirConexao();
        String query = "SELECT * FROM `usuario_time`";
        try {
            // List to return results
            List<UsuarioTime> allTimes = new ArrayList<UsuarioTime>();

            PreparedStatement ps = this.conexao.getConexao().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            // How to take in DB
            while (rs.next()) {
                UsuarioDao usuarioDao = new UsuarioDao();
                TimeDao timeDao = new TimeDao();
                FuncaoTimeDao funcaoTimeDao = new FuncaoTimeDao();

                UsuarioTime ut = new UsuarioTime(rs.getLong("id_usuario_time"),
                        ConversaoDeData.timestampToLocalDateTime(rs.getTimestamp("data_entrada")),
                        usuarioDao.findById(rs.getLong("id_usuario")), timeDao.findById(rs.getLong("id_time")),
                        rs.getString("cargo"), funcaoTimeDao.findById(rs.getLong("id_funcao_time")));

                allTimes.add(ut);
            }

            return allTimes;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            conexao.fecharConexao();
        }
    }

    public UsuarioTime findById(long id) {
        this.conexao.abrirConexao();

        String query = "SELECT * FROM `usuario_time` WHERE id_usuario_time=?";

        UsuarioTime ut = null;
        // How to take in DB
        try {
            PreparedStatement ps = this.conexao.getConexao().prepareStatement(query);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                FuncaoTimeDao funcaoTimeDao = new FuncaoTimeDao();
                UsuarioDao usuarioDao = new UsuarioDao();
                TimeDao timeDao = new TimeDao();

                ut = new UsuarioTime(rs.getLong("id_usuario_time"),
                        ConversaoDeData.timestampToLocalDateTime(rs.getTimestamp("data_entrada")),
                        usuarioDao.findById(rs.getLong("id_usuario")), timeDao.findById(rs.getLong("id_time")),
                        rs.getString("cargo"), funcaoTimeDao.findById(rs.getLong("id_funcao_time")));
            }
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
        return ut;
    }

    public UsuarioTime findByIdTime(long id) {
        this.conexao.abrirConexao();

        String query = "SELECT * FROM `usuario_time` WHERE id_time=?";

        UsuarioTime ut = null;
        // How to take in DB
        try {
            PreparedStatement ps = this.conexao.getConexao().prepareStatement(query);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                FuncaoTimeDao funcaoTimeDao = new FuncaoTimeDao();
                UsuarioDao usuarioDao = new UsuarioDao();
                TimeDao timeDao = new TimeDao();

                ut = new UsuarioTime(rs.getLong("id_usuario_time"),
                        ConversaoDeData.timestampToLocalDateTime(rs.getTimestamp("data_entrada")),
                        usuarioDao.findById(rs.getLong("id_usuario")), timeDao.findById(rs.getLong("id_time")),
                        rs.getString("cargo"), funcaoTimeDao.findById(rs.getLong("id_funcao_time")));
            }
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
        return ut;
    }

    public UsuarioTime findByIdUsuario(long id) {
        this.conexao.abrirConexao();

        String query = "SELECT * FROM `usuario_time` WHERE id_usuario=?";

        UsuarioTime ut = null;
        // How to take in DB
        try {
            PreparedStatement ps = this.conexao.getConexao().prepareStatement(query);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                FuncaoTimeDao funcaoTimeDao = new FuncaoTimeDao();
                UsuarioDao usuarioDao = new UsuarioDao();
                TimeDao timeDao = new TimeDao();

                ut = new UsuarioTime(rs.getLong("id_usuario_time"),
                        ConversaoDeData.timestampToLocalDateTime(rs.getTimestamp("data_entrada")),
                        usuarioDao.findById(rs.getLong("id_usuario")), timeDao.findById(rs.getLong("id_time")),
                        rs.getString("cargo"), funcaoTimeDao.findById(rs.getLong("id_funcao_time")));
            }
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
        return ut;
    }

    public void postUsuarioTime(UsuarioTimeFullDto ut) {

        this.conexao.abrirConexao();
        String query = "INSERT INTO `usuario_time` VALUES(null,?,?,?,?,?)";
        try {
            PreparedStatement st = this.conexao.getConexao().prepareStatement(query);

            st.setTimestamp(1, ConversaoDeData.localDateTimeToTimestamp(LocalDateTime.now()));
            st.setString(2, ut.getCargo());
            st.setLong(3, ut.getFuncaoTime().getIdFuncaoTime());
            st.setLong(4, ut.getUsuario().getIdUsuario());
            st.setLong(5, ut.getTime().getIdTime());

            st.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }

    public void putUsuarioTime(UsuarioTime ut, long idUsuarioTime) {

        this.conexao.abrirConexao();
        String query = "UPDATE `usuario_time` SET data_entrada=?, id_usuario=?, id_time=?, cargo=?, id_funcao_time=?  WHERE id_usuario_time=?";
        try {
            PreparedStatement st = this.conexao.getConexao().prepareStatement(query);

            st.setTimestamp(1, ConversaoDeData.localDateTimeToTimestamp(ut.getDataEntrada()));
            st.setLong(2, ut.getUsuario().getIdUsuario());
            st.setLong(3, ut.getTime().getIdTime());
            st.setString(4, ut.getCargo());
            st.setLong(5, ut.getFuncaoTime().getIdFuncaoTime());

            st.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }

    public void delete(long id) {
        this.conexao.abrirConexao();
        String query = "DELETE FROM `usuario_time` WHERE id_usuario_time=?";
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
