package com.badulin.simpleapi.controller;

import com.badulin.simpleapi.model.Invention;
import com.badulin.simpleapi.service.InventionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = InventionController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class InventionController {
    public static final String REST_URL = "/api/v1/invention";

    private InventionService inventionService;

    @Autowired
    public InventionController(InventionService inventionService) {
        this.inventionService = inventionService;
    }

    @GetMapping(value = "/{id}")
    public Invention get(@PathVariable("id") Long id) {
        log.info("get " + id);
        return inventionService.get(id);
    }

    @GetMapping
    public List<Invention> getAll() {
       log.info("getAll");
       return inventionService.getAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Invention save(@RequestBody Invention invention) {
        log.info("save " + invention);
        return inventionService.save(invention);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        log.info("delete " +id);
        inventionService.delete(id);
    }




}
