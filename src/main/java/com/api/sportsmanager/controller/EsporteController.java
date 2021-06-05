package com.api.sportsmanager.controller;

import java.util.ArrayList;
import java.util.List;

import com.api.sportsmanager.dao.EsporteDao;
import com.api.sportsmanager.dto.EsporteDto;
import com.api.sportsmanager.entities.Esporte;

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
@RequestMapping("/esporte")
public class EsporteController {
    private static final Logger log = LoggerFactory.getLogger(EsporteController.class);
    private EsporteDao esporteDao;

    public EsporteController(EsporteDao esporteDao) {
        this.esporteDao = esporteDao;
    }

    @PostMapping
    public ResponseEntity<Void> post(@RequestBody Esporte e) {
        log.info("POST /esporte");

        try {
            if (esporteDao.findByNomeEsporte(e.getNome()) != null) {
                log.warn("Esporte with name " + e.getNome() + " already exist");
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            } else {
                esporteDao.postEsporte(e);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        } catch (Exception error) {
            log.error("Can´t post Esporte");
            log.error("ERROR " + error);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    public ResponseEntity<List<Esporte>> getAll() {
        log.info("GET /esporte");

        List<Esporte> allEsportes = esporteDao.findAll();
        List<EsporteDto> allEsportesDto = new ArrayList<EsporteDto>();

        for (Esporte e : allEsportes) {
            EsporteDto dto = new EsporteDto(e.getIdEsporte(), e.getNome(), e.getLogo(), e.getPlataforma());
            allEsportesDto.add(dto);
        }

        return new ResponseEntity<>(allEsportes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EsporteDto> getEsporteById(@PathVariable("id") long id) {
        log.info("GET /esporte/" + id);

        Esporte e = esporteDao.findById(id);
        EsporteDto dto = new EsporteDto(e.getIdEsporte(), e.getNome(), e.getLogo(), e.getPlataforma());

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> put(@PathVariable("id") long id, @RequestBody Esporte e) {
        log.info("PUT /esporte/" + id);

        if (esporteDao.findByNomeEsporte(e.getNome()) != null) {
            log.warn("Esporte with name " + e.getNome() + " already exist");
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {
            esporteDao.postEsporte(e);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        log.info("DELETE /esporte/" + id);

        try {
            esporteDao.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.error("Can´t delete esporte with id " + id);
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
