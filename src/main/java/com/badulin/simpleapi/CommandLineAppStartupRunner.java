package com.badulin.simpleapi;

import com.badulin.simpleapi.dao.InventionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppStartupRunner implements  CommandLineRunner {

    private final InventionRepository InventionsRepository;

    @Autowired
    public CommandLineAppStartupRunner(InventionRepository InventionsRepository) {
        this.InventionsRepository = InventionsRepository;
    }

    @Override
    public void run(String...args) throws Exception {
        System.out.println(InventionsRepository.findById(1L).get());
    }
}
