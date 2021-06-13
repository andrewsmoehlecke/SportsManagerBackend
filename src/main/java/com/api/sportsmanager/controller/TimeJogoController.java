package com.api.sportsmanager.controller;

import java.util.ArrayList;
import java.util.List;

import com.api.sportsmanager.dao.TimeJogoDao;
import com.api.sportsmanager.dto.TimeJogoDto;
import com.api.sportsmanager.entities.TimeJogo;

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
@RequestMapping("/time_jogo")
public class TimeJogoController {
    private static final Logger log = LoggerFactory.getLogger(TimeJogoController.class);
    private TimeJogoDao timeJogoDao;

    public TimeJogoController(TimeJogoDao timeJogoDao) {
        this.timeJogoDao = timeJogoDao;
    }

    @PostMapping
    public ResponseEntity<Void> post(@RequestBody TimeJogo tj) {
        log.info("POST /time_jogo");

        try {
            timeJogoDao.postTimeJogo(tj);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.error("Can´t post TimeJogo with date " + tj.getDataJogo());
            log.error("ERROR " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    public ResponseEntity<List<TimeJogoDto>> getAll() {
        log.info("GET /time_jogo");

        List<TimeJogo> allTimeJogo = timeJogoDao.findAll();
        List<TimeJogoDto> allTimeJogoDto = new ArrayList<TimeJogoDto>();

        for (TimeJogo tj : allTimeJogo) {
            TimeJogoDto dto = new TimeJogoDto(tj.getIdTimeJogo(), tj.getLocal(), tj.getPontuacaoTime1(),
                    tj.getPontuacaoTime2(), tj.getDataJogo(), tj.getTime1().getIdTime(), tj.getTime2().getIdTime(),
                    tj.getTitulo());

            allTimeJogoDto.add(dto);
            log.info(dto.toString());
        }
        return new ResponseEntity<>(allTimeJogoDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeJogoDto> getTimeJogoById(@PathVariable("id") long id) {
        log.info("GET /time_jogo/" + id);

        TimeJogo tj = timeJogoDao.findById(id);
        TimeJogoDto dto = new TimeJogoDto(tj.getIdTimeJogo(), tj.getLocal(), tj.getPontuacaoTime1(),
                tj.getPontuacaoTime2(), tj.getDataJogo(), tj.getTime1().getIdTime(), tj.getTime2().getIdTime(),
                tj.getTitulo());

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> put(@PathVariable("id") long id, @RequestBody TimeJogo tj) {
        log.info("PUT /time_jogo/" + id);

        timeJogoDao.putTimeJogo(tj, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        log.info("DELETE /time_jogo/" + id);

        try {
            timeJogoDao.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.error("Can´t delete TimeJogo with id " + id);
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
