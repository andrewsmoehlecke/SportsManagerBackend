package com.api.sportsmanager.controller;

import java.util.List;

import com.api.sportsmanager.dao.CampeonatoDao;
import com.api.sportsmanager.entities.Campeonato;

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
@RequestMapping("/campeonato")
public class CampeonatoController {
    private static final Logger log = LoggerFactory.getLogger(UsuarioController.class);
    private CampeonatoDao campeonatoDao;

    public CampeonatoController(CampeonatoDao campeonatoDao) {
        this.campeonatoDao = campeonatoDao;
    }

    @PostMapping
    public ResponseEntity<Void> post(@RequestBody Campeonato c) {
        log.info("POST /campeonato");

        try {
            campeonatoDao.postCampeonato(c);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.error("Can´t post Campeonato " + c.getNome());
            log.error("ERROR " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    public ResponseEntity<List<Campeonato>> getAll() {
        log.info("GET /campeonato");

        List<Campeonato> allCampeonatos = campeonatoDao.findAll();
        return new ResponseEntity<>(allCampeonatos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Campeonato> getCampeonatoById(@PathVariable("id") long id) {
        log.info("GET /campeonato/" + id);

        Campeonato c = campeonatoDao.findById(id);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> put(@PathVariable("id") long id, @RequestBody Campeonato c) {
        log.info("PUT /campeonato/" + id);

        campeonatoDao.putCampeonato(c, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        log.info("DELETE /campeonato/" + id);

        try {
            campeonatoDao.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.error("Can´t delete Campeonato with id " + id);
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
