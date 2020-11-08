package com.badulin.simpleapi.dao;
import com.badulin.simpleapi.model.Inno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface InnoRepository extends JpaRepository<Inno, Long> {
    @Transactional
    @Modifying
    @Query("delete from Inno i where i.id=:id")
    int delete(@Param("id") Long id);

    @Query("SELECT m FROM Inno m JOIN FETCH m.invention WHERE m.id = ?1 and m.invention.id = ?2")
    Inno getInventor(Long id, Long inventionId);
}
