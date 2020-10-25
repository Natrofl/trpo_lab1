package com.badulin.simpleapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.badulin.simpleapi.model.Invention;
import com.badulin.simpleapi.dao.InventionRepository;

import java.util.List;

@Service
public class InventionServiceImpl implements InventionService {

    private final InventionRepository inventionRepository;

    @Autowired
    public InventionServiceImpl(InventionRepository inventionRepository) {
        this.inventionRepository = inventionRepository;
    }

    @Override
    public Invention get(Long id) {
        return inventionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Invention> getAll() {
        return inventionRepository.findAll();
    }

    @Override
    public Invention save(Invention inventions) {
        return null;
    }

    @Override
    public void  delete(Long id) {
        inventionRepository.delete(id);
    }
}
