package com.badulin.simpleapi.controller;

import com.badulin.simpleapi.model.Inno;
import com.badulin.simpleapi.service.InnoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = InnoController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class InnoController {
    public static final String REST_URL = "/api/v1/inno";

    private InnoService innoService;

    public InnoController(InnoService innoService) {
        this.innoService = innoService;
    }

    @GetMapping(value = "/{id}")
    public Inno get(@PathVariable("id") Long id) {
        log.info("get " + id);
        return innoService.get(id);
    }

    @GetMapping
    public List<Inno> getAll() {
        log.info("getAll");
        return innoService.getAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Inno save(@RequestBody Inno inno) {
        log.info("save " + inno);
        return innoService.save(inno);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        log.info("delete " +id);
        innoService.delete(id);
    }

}
