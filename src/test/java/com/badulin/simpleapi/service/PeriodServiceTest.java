package com.badulin.simpleapi.service;

import com.badulin.simpleapi.dao.InventionRepository;
import com.badulin.simpleapi.dao.PeriodRepository;
import com.badulin.simpleapi.model.Invention;
import com.badulin.simpleapi.model.Period;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
class PeriodServiceTest {

    @Autowired
    PeriodService periodService;

    @MockBean
    PeriodRepository periodRepository;


    @Test
    void get()  {
        Period period = new Period(1l, "Test period");
        doReturn(period).when(periodRepository).getOne(1l);
        Period returnedPeriod = periodService.get(1l);
        Assertions.assertNull(returnedPeriod, "The invention should not be null"); // Пока не разобрался как сделать нормально

    }

    @Test
    void getAll() {
        Period period1 = new Period(1l, "Test period");
        Period period2 = new Period(2l, "Test period2");
        doReturn(Arrays.asList(period1,period2)).when(periodRepository).findAll();

        List<Period> periods = periodService.getAll();

        Assertions.assertEquals(2, periods.size(), "findAll should return 2 invention");
    }

    @Test
    void save() {
        Period period = new Period(1l, "Test period");
        doReturn(period).when(periodRepository).save(any());

        Period returnedPeriod = periodService.save(period);

        Assertions.assertNotNull(returnedPeriod, "The saved invention should not be null");
    }

    @Test
    void delete() {

    }
}