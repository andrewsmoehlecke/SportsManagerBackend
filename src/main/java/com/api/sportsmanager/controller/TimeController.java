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
    public ResponseEntity post(@RequestBody Time time) {
        log.info("Post /time");

        timeDao.postTime(time);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Buscar por todos os times
    @GetMapping()
    public ResponseEntity<List<Time>> get() {
        log.info("GET /time");
        timeDao.postTime(new Time());

        // List<Time> allTimes = timeDao.findAll();
        // return new ResponseEntity<>(allTimes, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Buscar time pelo id
    @GetMapping("/{id}")
    public ResponseEntity<Time> getOne(@PathVariable long id) {
        log.info("GET /time/" + id);

        Time t = timeDao.findById(id);
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    // atualizar time pelo id
    @PutMapping("/{id}")
    public ResponseEntity<Time> put(@PathVariable long id, @RequestBody Time time) {
        // just example (not working)
        // Att Time here
        Time t = new Time();
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    // deletar time pelo id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        // just example (not working)
        // Delete Time here
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
