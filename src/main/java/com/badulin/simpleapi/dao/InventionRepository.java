package com.badulin.simpleapi.dao;
import com.badulin.simpleapi.model.Invention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface InventionRepository extends JpaRepository<Invention, Long>  {
    @Transactional
    @Modifying
    List<Invention> findByPeriodId(Long periodId);
}

