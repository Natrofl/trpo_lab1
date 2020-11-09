package com.badulin.simpleapi.dao;
import com.badulin.simpleapi.model.Area;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {
    @Transactional
    @Modifying
    @Query("delete from Area i where i.id=:id")
    int delete(@Param("id") Long id);

    List<Area> findByInvId(Long invId);


}
