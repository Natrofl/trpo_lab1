package com.badulin.simpleapi.service;

import com.badulin.simpleapi.model.Invention;
import com.badulin.simpleapi.model.Period;

import java.util.List;

public interface PeriodService  {
    Period get(Long id);

    List<Period> getAll();

    Period save(Period period);

    void delete(Long id);
}
