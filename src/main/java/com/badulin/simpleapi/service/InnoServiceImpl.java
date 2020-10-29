package com.badulin.simpleapi.service;

import com.badulin.simpleapi.model.Inno;
import com.badulin.simpleapi.model.Invention;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import com.badulin.simpleapi.dao.InnoRepository;

import java.util.List;

@Service
public class InnoServiceImpl implements InnoService {

    private final InnoRepository innoRepository;

    public InnoServiceImpl(InnoRepository innoRepository) {
        this.innoRepository = innoRepository;
    }

    @Override
    public Inno get(Long id) {
        return innoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Inno> getAll() {
        return innoRepository.findAll();
    }

    @Override
    public Inno save(Inno inno) {
        return innoRepository.save(inno);
    }

    @Override
    public void delete(Long id) {
        innoRepository.delete(id);
    }

    @Override
    public Inno getInventor(Long id, Long inventionId) {
        return innoRepository.getInventor(id, inventionId);
    }

}
