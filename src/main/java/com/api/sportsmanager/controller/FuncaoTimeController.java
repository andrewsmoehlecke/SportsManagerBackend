package com.api.sportsmanager.controller;

import java.util.ArrayList;
import java.util.List;

import com.api.sportsmanager.dao.FuncaoTimeDao;
import com.api.sportsmanager.dto.FuncaoTimeDto;
import com.api.sportsmanager.entities.FuncaoTime;

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
@RequestMapping("/funcao_time")
public class FuncaoTimeController {
    private static final Logger log = LoggerFactory.getLogger(FuncaoTimeController.class);
    private FuncaoTimeDao funcaoTimeDao;

    public FuncaoTimeController(FuncaoTimeDao funcaoTimeDao) {
        this.funcaoTimeDao = funcaoTimeDao;
    }

    @PostMapping
    public ResponseEntity<FuncaoTimeDto> post(@RequestBody FuncaoTimeDto ft) {
        log.info("POST /funcao_time");

        try {
            funcaoTimeDao.postFuncaoTime(ft);
            return new ResponseEntity<>(ft, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Can´t post FuncaoTime");
            log.error("ERROR " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    public ResponseEntity<List<FuncaoTimeDto>> getAll() {
        log.info("GET /funcao_time");

        List<FuncaoTime> allFuncaoTime = funcaoTimeDao.findAll();
        List<FuncaoTimeDto> allFuncaoTimeDto = new ArrayList<FuncaoTimeDto>();

        for (FuncaoTime ft : allFuncaoTime) {
            FuncaoTimeDto dto = new FuncaoTimeDto(ft.getIdFuncaoTime(), ft.getNome());

            allFuncaoTimeDto.add(dto);
        }
        return new ResponseEntity<>(allFuncaoTimeDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncaoTimeDto> getFuncaoTimeById(@PathVariable("id") long id) {
        log.info("GET /funcao_time/" + id);

        FuncaoTime ft = funcaoTimeDao.findById(id);
        FuncaoTimeDto dto = new FuncaoTimeDto(ft.getIdFuncaoTime(), ft.getNome());

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncaoTimeDto> put(@PathVariable("id") long id, @RequestBody FuncaoTimeDto ft) {
        log.info("PUT /funcao_time/" + id);

        funcaoTimeDao.putFuncaoTime(ft, id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        log.info("DELETE /funcao_time/" + id);

        try {
            funcaoTimeDao.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.error("Can´t delete FuncaoTime with id " + id);
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
