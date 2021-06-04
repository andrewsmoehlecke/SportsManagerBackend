package com.api.sportsmanager.controller;

import java.util.List;

import com.api.sportsmanager.dao.JogoDao;
import com.api.sportsmanager.entities.Jogo;

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
@RequestMapping("/jogo")
public class JogoController {

    private static final Logger log = LoggerFactory.getLogger(JogoController.class);
    private JogoDao jogoDao;

    public JogoController(JogoDao jogoDao) {
        this.jogoDao = jogoDao;
    }

    @PostMapping
    public ResponseEntity<Void> post(@RequestBody Jogo j) {
        log.info("POST /jogo");

        try {
            jogoDao.postJogo(j);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.error("Can´t post Jogo");
            log.error("ERROR " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    public ResponseEntity<List<Jogo>> getAll() {
        log.info("GET /jogo");

        List<Jogo> allJogos = jogoDao.findAll();
        return new ResponseEntity<>(allJogos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogo> getJogoById(@PathVariable("id") long id) {
        log.info("GET /jogo/" + id);

        Jogo j = jogoDao.findById(id);
        return new ResponseEntity<>(j, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> put(@PathVariable("id") long id, @RequestBody Jogo j) {
        log.info("PUT /jogo/" + id);

        jogoDao.putJogo(j, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        log.info("DELETE /jogo/" + id);

        try {
            jogoDao.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.error("Can´t delete Jogo with id " + id);
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
