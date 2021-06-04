package com.api.sportsmanager.controller;

import java.util.List;

import com.api.sportsmanager.dao.TimeDao;
import com.api.sportsmanager.entities.Time;
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
@RequestMapping("/time")
public class TimeController {

    private TimeDao timeDao;

    public TimeController(TimeDao td) {
        this.timeDao = td;
    }

    private static final Logger log = LoggerFactory.getLogger(TimeController.class);

    // Criar novo time
    @PostMapping
    public ResponseEntity<Void> post(@RequestBody Time time) {
        log.info("Post /time");

        try {
            // verify if time already exist
            if (timeDao.findByNomeTime(time.getNomeTime()) != null) {
                log.warn("Time with name " + time.getNomeTime() + " already exist");
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            } else {
                timeDao.postTime(time);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error("Can´t post time " + time.getNomeTime());
            log.error("ERROR " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Buscar por todos os times
    @GetMapping()
    public ResponseEntity<List<Time>> getAll() {
        log.info("GET /time");

        List<Time> allTimes = timeDao.findAll();
        return new ResponseEntity<>(allTimes, HttpStatus.OK);
    }

    // Buscar time pelo id
    @GetMapping("/{id}")
    public ResponseEntity<Time> getTimeById(@PathVariable("id") long id) {
        log.info("GET /time/" + id);

        Time t = timeDao.findById(id);
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    // atualizar time pelo id
    @PutMapping("/{id}")
    public ResponseEntity<Void> put(@PathVariable("id") long idTime, @RequestBody Time time) {
        log.info("PUT /time/" + idTime);
        // Att Time here
        timeDao.putTime(time, idTime);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // deletar time pelo id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        log.info("DELETE /time/" + id);

        try {
            timeDao.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.error("Can´t delete Time with id " + id);
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
