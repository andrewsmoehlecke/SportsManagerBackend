package com.api.sportsmanager.controller;

import org.springframework.stereotype.Service;

import java.util.List;

import com.api.sportsmanager.dao.CampeonatoTimeDao;
import com.api.sportsmanager.dao.UsuarioDao;
import com.api.sportsmanager.entities.CampeonatoTime;
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

@RestController
@CrossOrigin
@RequestMapping("/campeonato_time")
public class CampeonatoTimeController {
    private static final Logger log = LoggerFactory.getLogger(CampeonatoTimeController.class);
    private CampeonatoTimeDao campeonatoTimeDao;

    public CampeonatoTimeController(CampeonatoTimeDao campeonatoTimeDao) {
        this.campeonatoTimeDao = campeonatoTimeDao;
    }

    @PostMapping
    public ResponseEntity<Void> post(@RequestBody CampeonatoTime ct) {
        log.info("POST /campeonato_time");

        try {
            campeonatoTimeDao.postCampeonatoTime(ct);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.error("Can´t post CampeonatoTime");
            log.error("ERROR " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    public ResponseEntity<List<CampeonatoTime>> getAll() {
        log.info("GET /campeonato_time");

        List<CampeonatoTime> allCampeonatoTime = campeonatoTimeDao.findAll();
        return new ResponseEntity<>(allCampeonatoTime, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampeonatoTime> getCampeonatoTimeById(@PathVariable("id") long id) {
        log.info("GET /campeonato_time/" + id);

        CampeonatoTime ct = campeonatoTimeDao.findById(id);
        return new ResponseEntity<>(ct, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> put(@PathVariable("id") long id, @RequestBody CampeonatoTime ct) {
        log.info("PUT /campeontao_time/" + id);

        campeonatoTimeDao.putCampeonatoTime(ct, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        log.info("DELETE /campeonato_time/" + id);

        try {
            campeonatoTimeDao.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.error("Can´t delete CampeonatoTimeDao with id " + id);
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
