package com.api.sportsmanager.controller;

import java.util.ArrayList;
import java.util.List;

import com.api.sportsmanager.dao.TimeDao;
import com.api.sportsmanager.dao.TimeJogoDao;
import com.api.sportsmanager.dto.TimeDto;
import com.api.sportsmanager.dto.TimeJogoDto;
import com.api.sportsmanager.dto.TimeJogoFullDto;
import com.api.sportsmanager.entities.Time;
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
    public ResponseEntity<Void> post(@RequestBody TimeJogoFullDto dto) {
        log.info("POST /time_jogo");

        try {
            timeJogoDao.postTimeJogo(dto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.error("Can´t post TimeJogo with date " + dto.getDataJogo());
            log.error("ERROR " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    public ResponseEntity<List<TimeJogoFullDto>> getAll() {
        log.info("GET /time_jogo");

        List<TimeJogo> allTimeJogo = timeJogoDao.findAll();
        List<TimeJogoFullDto> allTimeJogoFullDto = new ArrayList<TimeJogoFullDto>();

        for (TimeJogo tj : allTimeJogo) {
            Time t1 = tj.getTime1();
            Time t2 = tj.getTime2();

            TimeJogoFullDto dto = new TimeJogoFullDto();
            TimeDto time1 = new TimeDto(t1.getIdTime(), t1.getNomeTime(), t1.getNumVitoria(), t1.getNumEmpate(),
                    t1.getNumDerrota(), t1.getDataCriacao(), t1.getFotoTime());
            TimeDto time2 = new TimeDto(t2.getIdTime(), t2.getNomeTime(), t2.getNumVitoria(), t2.getNumEmpate(),
                    t2.getNumDerrota(), t2.getDataCriacao(), t2.getFotoTime());

            dto.setIdTimeJogo(tj.getIdTimeJogo());
            dto.setLocal(tj.getLocal());
            dto.setPontuacaoTime1(tj.getPontuacaoTime1());
            dto.setPontuacaoTime2(tj.getPontuacaoTime2());
            dto.setDataJogo(tj.getDataJogo());
            dto.setTime1(time1);
            dto.setTime2(time2);
            dto.setTitulo(tj.getTitulo());

            allTimeJogoFullDto.add(dto);
        }
        return new ResponseEntity<>(allTimeJogoFullDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeJogoFullDto> getTimeJogoById(@PathVariable("id") long id) {
        log.info("GET /time_jogo/" + id);

        TimeJogo tj = timeJogoDao.findById(id);

        Time t1 = tj.getTime1();
        Time t2 = tj.getTime2();
        TimeJogoFullDto dto = new TimeJogoFullDto();

        TimeDto time1 = new TimeDto(t1.getIdTime(), t1.getNomeTime(), t1.getNumVitoria(), t1.getNumEmpate(),
                t1.getNumDerrota(), t1.getDataCriacao(), t1.getFotoTime());
        TimeDto time2 = new TimeDto(t2.getIdTime(), t2.getNomeTime(), t2.getNumVitoria(), t2.getNumEmpate(),
                t2.getNumDerrota(), t2.getDataCriacao(), t2.getFotoTime());

        dto.setIdTimeJogo(tj.getIdTimeJogo());
        dto.setLocal(tj.getLocal());
        dto.setPontuacaoTime1(tj.getPontuacaoTime1());
        dto.setPontuacaoTime2(tj.getPontuacaoTime2());
        dto.setDataJogo(tj.getDataJogo());
        dto.setTime1(time1);
        dto.setTime2(time2);
        dto.setTitulo(tj.getTitulo());

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TimeJogoFullDto> put(@PathVariable("id") long id, @RequestBody TimeJogoFullDto tj) {
        log.info("PUT /time_jogo/" + id);

        if (timeJogoDao.putTimeJogo(tj, id)) {
            return new ResponseEntity<>(tj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
