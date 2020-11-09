package com.badulin.simpleapi.dao;

import com.badulin.simpleapi.model.Period;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface PeriodRepository extends JpaRepository<Period, Long> {
    @Transactional
    @Modifying
    @Query("delete from Period i where i.id=:id")
    int delete(@Param("id") Long id);
}
