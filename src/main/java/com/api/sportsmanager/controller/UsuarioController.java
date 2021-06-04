package com.api.sportsmanager.controller;

import java.util.List;

import com.api.sportsmanager.dao.UsuarioDao;
import com.api.sportsmanager.entities.Usuario;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@CrossOrigin
@RequestMapping("/usuario")
public class UsuarioController {

    private static final Logger log = LoggerFactory.getLogger(UsuarioController.class);
    private UsuarioDao usuarioDao;

    public UsuarioController(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    @PostMapping
    public ResponseEntity<Void> post(@RequestBody Usuario u) {
        log.info("POST /usuario");

        try {
            // verify if Usuario already exist
            if (usuarioDao.findByUsername(u.getUsername()) != null) {
                log.warn("Usuario with name " + u.getUsername() + " already exist");
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            } else {
                usuarioDao.postUsuario(u);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error("Can´t post Usuario " + u.getUsername());
            log.error("ERROR " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Buscar por todos os Usuarios
    @GetMapping()
    public ResponseEntity<List<Usuario>> getAll() {
        log.info("GET /usuario");

        List<Usuario> allUsuarios = usuarioDao.findAll();
        return new ResponseEntity<>(allUsuarios, HttpStatus.OK);
    }

    // Buscar Usuario pelo id
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable("id") long id) {
        log.info("GET /usuario/" + id);

        Usuario u = usuarioDao.findById(id);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    // atualizar Usuario pelo id
    @PutMapping("/{id}")
    public ResponseEntity<Void> put(@PathVariable("id") long id, @RequestBody Usuario u) {
        log.info("PUT /usuario/" + id);

        if (usuarioDao.findByUsername(u.getUsername()) != null) {
            log.warn("Usuario with name " + u.getUsername() + " already exist");
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {
            usuarioDao.putUsuario(u, id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    // deletar Usuario pelo id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        log.info("DELETE /usuario/" + id);

        try {
            usuarioDao.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.error("Can´t delete Usuario with id " + id);
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
