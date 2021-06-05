package com.api.sportsmanager.controller;

import java.util.ArrayList;
import java.util.List;

import com.api.sportsmanager.dao.UsuarioTimeDao;
import com.api.sportsmanager.dto.UsuarioTimeDto;
import com.api.sportsmanager.entities.UsuarioTime;

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

@RestController
@CrossOrigin
@RequestMapping("/usuario_time")
public class UsuarioTimeController {

    private static final Logger log = LoggerFactory.getLogger(UsuarioTimeController.class);
    private UsuarioTimeDao usuarioTimeDao;

    public UsuarioTimeController(UsuarioTimeDao usuarioTimeDao) {
        this.usuarioTimeDao = usuarioTimeDao;
    }

    @PostMapping
    public ResponseEntity<Void> post(@RequestBody UsuarioTime ut) {
        log.info("POST /usuario_time");

        try {
            usuarioTimeDao.postUsuarioTime(ut);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.error("Can´t post Usuario with id " + ut.getUsuario().getIdUsuario());
            log.error("ERROR " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    public ResponseEntity<List<UsuarioTimeDto>> getAll() {
        log.info("GET /usuario_time");

        List<UsuarioTime> allUsuarioTime = usuarioTimeDao.findAll();
        List<UsuarioTimeDto> allUsuarioTimeDto = new ArrayList<UsuarioTimeDto>();

        for (UsuarioTime ut : allUsuarioTime) {
            UsuarioTimeDto dto = new UsuarioTimeDto(ut.getIdUsuarioTime(), ut.getDataEntrada(), ut.getCargo(),
                    ut.getUsuario().getIdUsuario(), ut.getTime().getIdTime(), ut.getFuncaoTime().getIdFuncaoTime());

            allUsuarioTimeDto.add(dto);
        }
        return new ResponseEntity<>(allUsuarioTimeDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioTimeDto> getUsuarioTimeById(@PathVariable("id") long id) {
        log.info("GET /usuario_time/" + id);

        UsuarioTime ut = usuarioTimeDao.findById(id);
        UsuarioTimeDto dto = new UsuarioTimeDto(ut.getIdUsuarioTime(), ut.getDataEntrada(), ut.getCargo(),
                ut.getUsuario().getIdUsuario(), ut.getTime().getIdTime(), ut.getFuncaoTime().getIdFuncaoTime());

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> put(@PathVariable("id") long id, @RequestBody UsuarioTime ut) {
        log.info("PUT /usuario_time/" + id);

        usuarioTimeDao.putUsuarioTime(ut, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        log.info("DELETE /usuario_time/" + id);

        try {
            usuarioTimeDao.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.error("Can´t delete UsuarioTime with id " + id);
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
