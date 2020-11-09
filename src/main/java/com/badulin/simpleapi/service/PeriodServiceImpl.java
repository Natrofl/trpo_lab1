package com.badulin.simpleapi.service;

import com.badulin.simpleapi.dao.PeriodRepository;
import com.badulin.simpleapi.model.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeriodServiceImpl implements PeriodService {

    private final PeriodRepository periodRepository;


    @Autowired
    public PeriodServiceImpl(PeriodRepository periodRepository) {
        this.periodRepository = periodRepository;
    }

    @Override
    public Period get(Long id) {
        return periodRepository.findById(id).orElse(null);
    }

    @Override
    public List<Period> getAll() {
        return periodRepository.findAll();
    }

    @Override
    public Period save(Period period) {
        return periodRepository.save(period);
    }

    @Override
    public void  delete(Long id) {
        periodRepository.delete(id);
    }
}
