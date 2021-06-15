package com.api.sportsmanager.controller;

import java.util.ArrayList;
import java.util.List;

import com.api.sportsmanager.dao.UsuarioDao;
import com.api.sportsmanager.dto.UsuarioDto;
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

    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody UsuarioDto dto) {
        Usuario u = usuarioDao.findByUsername(dto.getUsername());

        if (u != null) {
            if (u.getSenha().equals(dto.getSenha())) {
                return new ResponseEntity<>(u, HttpStatus.OK);
            } else {
                log.warn("Password incorrect");
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            log.warn("Not found Usuario " + dto.getUsername());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<UsuarioDto> post(@RequestBody UsuarioDto dto) {
        log.info("POST /usuario");

        if (usuarioDao.findByUsername(dto.getUsername()) != null) {
            log.warn("Usuario with username " + dto.getUsername() + " already exist");
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else if (usuarioDao.findByEmail(dto.getEmail()) != null) {
            log.warn("Usuario with email " + dto.getEmail() + " already exist");
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {
            Usuario u = new Usuario();

            u.setUsername(dto.getUsername());
            u.setEmail(dto.getEmail());
            u.setSenha(dto.getSenha());
            u.setFotoPerfil(dto.getFotoPerfil());

            if (usuarioDao.postUsuario(u) != null) {
                log.info("User " + dto.getUsername() + " created");
                return new ResponseEntity<>(dto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    // Buscar por todos os Usuarios
    @GetMapping()
    public ResponseEntity<List<UsuarioDto>> getAll() {
        log.info("GET /usuario");

        List<Usuario> allUsuarios = usuarioDao.findAll();
        List<UsuarioDto> allUsuariosDto = new ArrayList<UsuarioDto>();

        for (Usuario u : allUsuarios) {
            UsuarioDto dto = new UsuarioDto(u.getIdUsuario(), u.getUsername(), u.getEmail(), u.getSenha(),
                    u.getDataCriacao(), u.getFotoPerfil());

            allUsuariosDto.add(dto);
        }
        return new ResponseEntity<>(allUsuariosDto, HttpStatus.OK);
    }

    // Buscar Usuario pelo id
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> getUsuarioById(@PathVariable("id") long id) {
        log.info("GET /usuario/" + id);

        Usuario u = usuarioDao.findById(id);
        UsuarioDto dto = new UsuarioDto(u.getIdUsuario(), u.getUsername(), u.getEmail(), u.getSenha(),
                u.getDataCriacao(), u.getFotoPerfil());

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> put(@PathVariable("id") long id, @RequestBody UsuarioDto dto) {
        log.info("PUT /usuario/" + id);

        Usuario u = new Usuario();

        u.setUsername(dto.getUsername());
        u.setEmail(dto.getEmail());
        u.setSenha(dto.getSenha());
        u.setFotoPerfil(dto.getFotoPerfil());

        usuarioDao.putUsuario(u, id);

        return new ResponseEntity<>(dto, HttpStatus.OK);
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
