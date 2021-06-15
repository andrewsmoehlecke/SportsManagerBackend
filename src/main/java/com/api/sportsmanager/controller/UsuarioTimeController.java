package com.api.sportsmanager.controller;

import java.util.ArrayList;
import java.util.List;

import com.api.sportsmanager.dao.UsuarioTimeDao;
import com.api.sportsmanager.dto.FuncaoTimeDto;
import com.api.sportsmanager.dto.TimeDto;
import com.api.sportsmanager.dto.UsuarioDto;
import com.api.sportsmanager.dto.UsuarioTimeDto;
import com.api.sportsmanager.dto.UsuarioTimeFullDto;
import com.api.sportsmanager.entities.FuncaoTime;
import com.api.sportsmanager.entities.Time;
import com.api.sportsmanager.entities.Usuario;
import com.api.sportsmanager.entities.UsuarioTime;

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
@RequestMapping("/usuario_time")
public class UsuarioTimeController {

    private static final Logger log = LoggerFactory.getLogger(UsuarioTimeController.class);
    private UsuarioTimeDao usuarioTimeDao;

    public UsuarioTimeController(UsuarioTimeDao usuarioTimeDao) {
        this.usuarioTimeDao = usuarioTimeDao;
    }

    @PostMapping
    public ResponseEntity<Void> post(@RequestBody UsuarioTimeFullDto ut) {
        log.info("POST /usuario_time");

        try {
            usuarioTimeDao.postUsuarioTime(ut);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.error("Can´t post Usuario with id " + ut.getUsuario().getIdUsuario());
            log.error("ERROR " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    public ResponseEntity<List<UsuarioTimeDto>> getAll() {
        log.info("GET /usuario_time");

        List<UsuarioTime> allUsuarioTime = usuarioTimeDao.findAll();
        List<UsuarioTimeDto> allUsuarioTimeDto = new ArrayList<UsuarioTimeDto>();

        for (UsuarioTime ut : allUsuarioTime) {
            UsuarioTimeDto dto = new UsuarioTimeDto(ut.getIdUsuarioTime(), ut.getDataEntrada(), ut.getCargo(),
                    ut.getUsuario().getIdUsuario(), ut.getTime().getIdTime(), ut.getFuncaoTime().getIdFuncaoTime());

            allUsuarioTimeDto.add(dto);
        }
        return new ResponseEntity<>(allUsuarioTimeDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioTimeDto> getUsuarioTimeById(@PathVariable("id") long id) {
        log.info("GET /usuario_time/" + id);

        UsuarioTime ut = usuarioTimeDao.findById(id);
        UsuarioTimeDto dto = new UsuarioTimeDto(ut.getIdUsuarioTime(), ut.getDataEntrada(), ut.getCargo(),
                ut.getUsuario().getIdUsuario(), ut.getTime().getIdTime(), ut.getFuncaoTime().getIdFuncaoTime());

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/time/{id}")
    public ResponseEntity<List<UsuarioTimeFullDto>> getUsuarioTimeByIdTime(@PathVariable("id") long id) {
        log.info("GET /usuario_time/time/" + id);

        List<UsuarioTime> utList = usuarioTimeDao.findByIdTime(id);
        List<UsuarioTimeFullDto> listDto = new ArrayList<UsuarioTimeFullDto>();

        for (UsuarioTime ut : utList) {
            UsuarioTimeFullDto dto = new UsuarioTimeFullDto();
            Usuario u = ut.getUsuario();
            Time t = ut.getTime();
            FuncaoTime ft = new FuncaoTime();

            UsuarioDto usuarioDto = new UsuarioDto();
            usuarioDto.setIdUsuario(u.getIdUsuario());
            usuarioDto.setUsername(u.getUsername());
            usuarioDto.setEmail(u.getEmail());
            usuarioDto.setSenha(u.getSenha());
            usuarioDto.setDataCriacao(u.getDataCriacao());
            usuarioDto.setFotoPerfil(u.getFotoPerfil());

            TimeDto timeDto = new TimeDto();
            timeDto.setIdTime(t.getIdTime());
            timeDto.setNomeTime(t.getNomeTime());
            timeDto.setNumVitoria(t.getNumVitoria());
            timeDto.setNumEmpate(t.getNumEmpate());
            timeDto.setNumDerrota(t.getNumDerrota());
            timeDto.setDataCriacao(t.getDataCriacao());
            timeDto.setFotoTime(t.getFotoTime());

            FuncaoTimeDto ftDto = new FuncaoTimeDto();
            ftDto.setIdFuncaoTime(ft.getIdFuncaoTime());
            ftDto.setNome(ft.getNome());

            dto.setIdUsuarioTime(ut.getIdUsuarioTime());
            dto.setDataEntrada(ut.getDataEntrada());
            dto.setCargo(ut.getCargo());
            dto.setUsuario(usuarioDto);
            dto.setTime(timeDto);
            dto.setFuncaoTime(ftDto);

            listDto.add(dto);
        }

        return new ResponseEntity<>(listDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> put(@PathVariable("id") long id, @RequestBody UsuarioTime ut) {
        log.info("PUT /usuario_time/" + id);

        usuarioTimeDao.putUsuarioTime(ut, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        log.info("DELETE /usuario_time/" + id);

        try {
            usuarioTimeDao.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.error("Can´t delete UsuarioTime with id " + id);
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
