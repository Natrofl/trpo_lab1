package com.badulin.simpleapi.controller;

import com.badulin.simpleapi.model.Area;
import com.badulin.simpleapi.service.AreaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = AreaController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AreaController {
    public static final String REST_URL = "/api/v1/area";

    private AreaService areaService;

    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    @GetMapping(value = "/{id}")
    public Area get(@PathVariable("id") Long id) {
        log.info("get " + id);
        return areaService.get(id);
    }

    @GetMapping
    public List<Area> getAll() {
        log.info("getAll");
        return areaService.getAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Area save(@RequestBody Area area) {
        log.info("save " + area);
        return areaService.save(area);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        log.info("delete " +id);
        areaService.delete(id);
    }

}
