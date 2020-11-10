package com.badulin.simpleapi.controller;


import com.badulin.simpleapi.dao.InventionRepository;
import com.badulin.simpleapi.model.Invention;
import com.badulin.simpleapi.service.InventionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;


import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.mockito.ArgumentMatchers.any;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.hamcrest.Matchers.*;



@AutoConfigureMockMvc
@SpringBootTest
class InventionControllerTest {
    @MockBean
    private InventionService inventionService;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InventionRepository repository;


    @Test
    @DisplayName("GET all inventions success")
    void findAll() throws Exception {
        Invention invention1 = new Invention(1l, "Пылесос", "Хьюберт Сесил Бут", "1901");
        Invention invention2 = new Invention(2l, "Пылесос", "Сесил Бут", "1907");

        doReturn(Lists.newArrayList(invention1, invention2)).when(inventionService).getAll();

        mockMvc.perform(get("/api/v1/invention"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("Пылесос")))
                .andExpect(jsonPath("$[0].inventor", is("Хьюберт Сесил Бут")))
                .andExpect(jsonPath("$[0].year", is("1901")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].name", is("Пылесос")))
                .andExpect(jsonPath("$[1].inventor", is("Сесил Бут")))
                .andExpect(jsonPath("$[1].year", is("1907")));
    }

    @DisplayName("POST invention success")
    @Test
    void save() throws Exception {
        Invention invention = new Invention("TestName", "TestInventor", "1901");
        Invention invToCheck = new Invention(1l,"TestName", "TestInventor", "1901");
        doReturn(invToCheck).when(inventionService).save(any());

        mockMvc.perform(post("/api/v1/invention")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(invention)))

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("TestName")))
                .andExpect(jsonPath("$.inventor", is("TestInventor")))
                .andExpect(jsonPath("$.year", is("1901")));
    }

    @DisplayName("GET invention by id success")
    @Test
    void getById() throws Exception {
        Invention invention = new Invention(1l,"TestName", "TestInventor", "1901");

        doReturn(invention).when(inventionService).get(1l);
        mockMvc.perform(get("/api/v1/invention/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.name").value("TestName"))
                .andExpect(jsonPath("$.inventor").value("TestInventor"))
                .andExpect(jsonPath("$.year").value("1901"));
    }

    @Test
    void deleteInvention() throws Exception{
        Invention invention = new Invention(1l,"Vacuumcleaner", "Vacuumcleaner Inventor", "1907");
        Mockito.when(repository.findById(Mockito.any())).thenReturn(Optional.of(invention));
        mockMvc.perform(
                delete("/api/v1/invention/1"))
                .andExpect(status().isOk());
    }

    @Test
    void getAllInventionByPeriodId() throws Exception {
          mockMvc.perform(get("/api/v1/invention/5/period", 1L))
                .andExpect(status().isOk());
    }

    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}