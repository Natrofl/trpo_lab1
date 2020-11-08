package com.badulin.simpleapi.service;

import com.badulin.simpleapi.model.Inno;
import java.util.List;
import java.util.Optional;


public interface InnoService  {
    Inno get(Long id);

    List<Inno> getAll();

    Inno save(Inno inno);

    void delete(Long id);

    Inno getInventor(Long id, Long inventionId);
}
