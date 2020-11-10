package com.badulin.simpleapi.service;

import com.badulin.simpleapi.model.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.badulin.simpleapi.dao.AreaRepository;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    private final AreaRepository areaRepository;

    @Autowired
    public AreaServiceImpl(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    @Override
    public Area get(Long id) {
        return areaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Area> getAll() {
        return areaRepository.findAll();
    }

    @Override
    public Area save(Area area) {
        return areaRepository.save(area);
    }

}
