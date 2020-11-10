package com.badulin.simpleapi.controller;

import com.badulin.simpleapi.dao.AreaRepository;
import com.badulin.simpleapi.exception.EntityNotFoundException;
import com.badulin.simpleapi.model.Area;
import com.badulin.simpleapi.service.AreaService;
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
public class AreaController {

    private AreaService areaService;

    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    @GetMapping(value = "/api/v1/area/{id}")
    public Area get(@PathVariable("id") Long id) {
        log.info("get " + id);
        return areaService.get(id);
    }

    @GetMapping(value = "/api/v1/area")
    public List<Area> getAll() {
        log.info("getAll");
        return areaService.getAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "/api/v1/area")
    public Area save(@RequestBody Area area) {
        log.info("save " + area);
        return areaService.save(area);
    }

    @DeleteMapping(value = "/api/v1/area/{id}")
    public ResponseEntity<Area> deleteArea(@PathVariable("id") Long id) throws EntityNotFoundException {
        Optional<Area> area = areaRepository.findById(id);
        if(!area.isPresent())
            throw new EntityNotFoundException("id: " + id);

        areaRepository.deleteById(id);
        return ResponseEntity.ok().body(area.get());
    }

    @Autowired
    private AreaRepository areaRepository;

    @GetMapping(value = "/api/v1/invention/{invId}/area")
    public List<Area> getAllAreasByInventionId(@PathVariable("invId") Long invId) { ;
        return areaRepository.findByInvId(invId);
    }

}
