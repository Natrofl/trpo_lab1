package com.badulin.simpleapi.controller;
import com.badulin.simpleapi.dto.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StatusControllerTest {



    @Test
    void get() throws Exception {
       Status status = new Status("test-hostname");

       String result = status.getHostName();
       Assertions.assertEquals(result, "test-hostname", "The hostname is similar");

    }

}