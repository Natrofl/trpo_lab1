package com.badulin.simpleapi.controller;

import com.badulin.simpleapi.dao.AreaRepository;
import com.badulin.simpleapi.dao.InventionRepository;
import com.badulin.simpleapi.model.Area;
import com.badulin.simpleapi.service.AreaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//@RequestMapping(value = AreaController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AreaController {
//    public static final String REST_URL = "/api/v1/area";

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
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        log.info("delete " +id);
        areaService.delete(id);
    }

    //New
    @Autowired
    private AreaRepository areaRepository;
    @Autowired
    private InventionRepository inventionRepository;


    @GetMapping(value = "/api/v1/invention/{invId}/area")
    public List<Area> getAllAreasByInventionId(@PathVariable("invId") Long invId) { ;
        return areaRepository.findByInvId(invId);
    }

}
