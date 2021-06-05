package com.api.sportsmanager.controller;

import java.util.ArrayList;
import java.util.List;

import com.api.sportsmanager.dao.EsporteTimeDao;
import com.api.sportsmanager.dto.EsporteTimeDto;
import com.api.sportsmanager.entities.EsporteTime;

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
@RequestMapping("/esporte_time")
public class EsporteTimeController {
    private static final Logger log = LoggerFactory.getLogger(EsporteTimeController.class);
    private EsporteTimeDao esporteTimeDao;

    public EsporteTimeController(EsporteTimeDao esporteTimeDao) {
        this.esporteTimeDao = esporteTimeDao;
    }

    @PostMapping
    public ResponseEntity<Void> post(@RequestBody EsporteTime et) {
        log.info("POST /esporte_time");

        try {
            esporteTimeDao.postEsporteTime(et);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.error("Can´t post EsporteTime");
            log.error("ERROR " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    public ResponseEntity<List<EsporteTimeDto>> getAll() {
        log.info("GET /esporte_time");

        List<EsporteTime> allEsporteTime = esporteTimeDao.findAll();
        List<EsporteTimeDto> allEsporteTimeDto = new ArrayList<EsporteTimeDto>();

        for (EsporteTime et : allEsporteTime) {
            EsporteTimeDto dto = new EsporteTimeDto(et.getIdEsporteTime(), et.getEsporte().getIdEsporte(),
                    et.getTime().getIdTime());

            allEsporteTimeDto.add(dto);
        }
        return new ResponseEntity<>(allEsporteTimeDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EsporteTimeDto> getEsporteTimeById(@PathVariable("id") long id) {
        log.info("GET /esporte_time/" + id);

        EsporteTime et = esporteTimeDao.findById(id);
        EsporteTimeDto dto = new EsporteTimeDto(et.getIdEsporteTime(), et.getEsporte().getIdEsporte(),
                et.getTime().getIdTime());

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> put(@PathVariable("id") long id, @RequestBody EsporteTime et) {
        log.info("PUT /esporte_time/" + id);

        esporteTimeDao.putEsporteTime(et, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        log.info("DELETE /esporte_time/" + id);

        try {
            esporteTimeDao.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.error("Can´t delete EsporteTime with id " + id);
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
