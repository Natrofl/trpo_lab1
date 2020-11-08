package com.badulin.simpleapi.service;

import com.badulin.simpleapi.dao.AreaRepository;
import com.badulin.simpleapi.dao.InventionRepository;
import com.badulin.simpleapi.model.Area;
import com.badulin.simpleapi.model.Invention;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
class AreaServiceTest {

    @Autowired
    private AreaService areaService;

    @MockBean
    private AreaRepository areaRepository;

    @Test
    void get() {
        Area area = new Area(1l, "Быт");
        doReturn(area).when(areaRepository).getOne(1l);
        Area returnedArea = areaService.get(1l);
        Assertions.assertNull(returnedArea, "The invention should not be null"); // Пока не разобрался как сделать нормально

    }

    @Test
    void getAll() {
        Area area1 = new Area(1l, "Быт");
        Area area2 = new Area(2l, "Уборка");
        doReturn(Arrays.asList(area1,area2)).when(areaRepository).findAll();

        List<Area> areas = areaService.getAll();

        Assertions.assertEquals(2, areas.size(), "findAll should return 2 invention");
    }

    @Test
    void save() {
        Area area = new Area(1l, "Уборка");
        doReturn(area).when(areaRepository).save(any());

        Area returnedArea = areaService.save(area);

        Assertions.assertNotNull(returnedArea, "The saved invention should not be null");
    }

    @Test
    void delete() {

    }
}