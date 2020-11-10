package com.badulin.simpleapi.controller;
import com.badulin.simpleapi.dto.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.InetAddress;

class StatusControllerTest {


    @Test
    void get() throws Exception {
        Status status = new Status(InetAddress.getLocalHost().getHostName());
        Assertions.assertNotNull(status, "The invention should not be null");

    }
}