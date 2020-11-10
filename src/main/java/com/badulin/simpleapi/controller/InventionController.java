package com.badulin.simpleapi.controller;


import com.badulin.simpleapi.dao.InventionRepository;
import com.badulin.simpleapi.exception.EntityNotFoundException;
import com.badulin.simpleapi.model.Invention;
import com.badulin.simpleapi.service.InventionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class InventionController {

    private InventionService inventionService;

    @Autowired
    public InventionController(InventionService inventionService) {
        this.inventionService = inventionService;
    }

    @GetMapping(value = "/api/v1/invention/{id}")
    public Invention get(@PathVariable("id") Long id) {
        log.info("get " + id);
        return inventionService.get(id);
    }

    @GetMapping(value = "/api/v1/invention")
    public List<Invention> getAll() {
       log.info("getAll");
       return inventionService.getAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "/api/v1/invention")
    public Invention save(@RequestBody Invention invention) {
        log.info("save " + invention);
        return inventionService.save(invention);
    }

    @DeleteMapping(value = "/api/v1/invention/{id}")
    public ResponseEntity<Invention> deleteInvention(@PathVariable("id") Long id) {
        Optional<Invention> invention = inventionRepository.findById(id);

        inventionRepository.deleteById(id);
        return ResponseEntity.ok().body(invention.get());
    }

    @Autowired
    private InventionRepository inventionRepository;

    @GetMapping(value = "/api/v1/invention/{periodId}/period")
    public List<Invention> getAllAreasByPeriodId(@PathVariable("periodId") Long periodId) { ;
        return inventionRepository.findByPeriodId(periodId);
    }

}
