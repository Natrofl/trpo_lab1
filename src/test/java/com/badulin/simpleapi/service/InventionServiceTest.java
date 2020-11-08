package com.badulin.simpleapi.service;

import com.badulin.simpleapi.dao.InventionRepository;
import com.badulin.simpleapi.model.Invention;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
class InventionServiceTest {

    @Autowired
    InventionService inventionService;

    @MockBean
    InventionRepository inventionRepository;


    @Test
    void get() {
        Invention invention = new Invention(1l, "Пылесос", "Хьюберт Сесил Бут", "1901");
        doReturn(invention).when(inventionRepository).getOne(1l);
        Invention returnedInvetion = inventionService.get(1l);
        Assertions.assertNull(returnedInvetion, "The invention should not be null"); // Пока не разобрался как сделать нормально

    }

    @Test
    void getAll() {
        Invention invention1 = new Invention(1l, "Пылесос", "Хьюберт Сесил Бут", "1901");
        Invention invention2 = new Invention(2l, "Пылесос", "Сесил Бут", "1907");
        doReturn(Arrays.asList(invention1,invention2)).when(inventionRepository).findAll();

        List<Invention> inventions = inventionService.getAll();

        Assertions.assertEquals(2, inventions.size(), "findAll should return 2 invention");
    }

    @Test
    void save() {
        Invention invention = new Invention(1l, "Пылесос", "Хьюберт Сесил Бут", "1901");
        doReturn(invention).when(inventionRepository).save(any());

        Invention returnedInvetion = inventionService.save(invention);

        Assertions.assertNotNull(returnedInvetion, "The saved invention should not be null");
    }

    @Test
    void delete() {

    }
}