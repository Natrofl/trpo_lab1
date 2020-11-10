package com.badulin.simpleapi.service;

import com.badulin.simpleapi.model.Area;
import java.util.List;

public interface AreaService  {
    Area get(Long id);

    List<Area> getAll();

    Area save(Area area);
}
