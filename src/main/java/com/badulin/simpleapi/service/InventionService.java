package com.badulin.simpleapi.service;

import com.badulin.simpleapi.model.Invention;

import java.util.List;

public interface InventionService {
    Invention get(Long id);

    List<Invention> getAll();

    Invention save(Invention invention);

    void delete(Long id);

}
