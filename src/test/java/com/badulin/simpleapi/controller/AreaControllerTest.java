package com.badulin.simpleapi.controller;

import com.badulin.simpleapi.dao.AreaRepository;
import com.badulin.simpleapi.model.Area;
import com.badulin.simpleapi.model.Invention;
import com.badulin.simpleapi.service.AreaService;
import com.badulin.simpleapi.service.InventionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

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
class AreaControllerTest {

    @MockBean
    private AreaService areaService;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AreaRepository repository;



    @Test
    @DisplayName("GET all areas  success")
    void findAll() throws Exception {
        Area area1 = new Area(1l, "Уборка");
        Area area2 = new Area(2l, "Быт");

        doReturn(Lists.newArrayList(area1, area2)).when(areaService).getAll();

        mockMvc.perform(get("/api/v1/area"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].area", is("Уборка")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].area", is("Быт")));
    }

    @Test
    @DisplayName("POST save area success")
    void save() throws Exception {
        Area area = new Area("TestArea");
        Area invToArea = new Area(1l,"TestArea");
        doReturn(invToArea).when(areaService).save(any());

        mockMvc.perform(post("/api/v1/area")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(area)))

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.area", is("TestArea")));
    }




    @Test
    @DisplayName("GET area byId success")
    void getById() throws Exception {
        Area area = new Area(1l,"TestArea");

        doReturn(area).when(areaService).get(1l);
        mockMvc.perform(get("/api/v1/area/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.area").value("TestArea"));
    }

    @Test
    void deleteArea()  throws Exception {
        Area area = new Area(1l, "Testarea");
        Mockito.when(repository.findById(Mockito.any())).thenReturn(Optional.of(area));
        mockMvc.perform(
                delete("/api/v1/area/1"))
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