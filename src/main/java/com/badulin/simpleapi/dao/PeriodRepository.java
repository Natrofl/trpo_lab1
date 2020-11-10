package com.badulin.simpleapi.dao;

import com.badulin.simpleapi.model.Period;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface PeriodRepository extends JpaRepository<Period, Long> {

}
