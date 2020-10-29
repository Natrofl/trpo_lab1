package com.badulin.simpleapi;

import com.badulin.simpleapi.dao.InventionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppStartupRunner implements  CommandLineRunner {

    private final InventionRepository InventionRepository;

    @Autowired
    public CommandLineAppStartupRunner(InventionRepository InventionRepository) {
        this.InventionRepository = InventionRepository;
    }

    @Override
    public void run(String...args) throws Exception {
      //  System.out.println(InventionRepository.findById(1L).get());
    }
}
