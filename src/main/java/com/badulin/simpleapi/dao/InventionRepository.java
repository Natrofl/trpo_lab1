package com.badulin.simpleapi.dao;
import com.badulin.simpleapi.model.Invention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface InventionRepository extends JpaRepository<Invention, Long>  {
    @Transactional
    @Modifying
    @Query("delete from Invention i where i.id=:id")
    int delete(@Param("id") Long id);

 //   @Query("SELECT i.id, i.inventor FROM Invention i JOIN FETCH inno io ON io.inventor_id  = i.id")

}

