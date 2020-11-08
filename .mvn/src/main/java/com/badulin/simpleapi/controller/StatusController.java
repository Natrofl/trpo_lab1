package com.badulin.simpleapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.net.InetAddress;
import java.net.UnknownHostException;
import com.badulin.simpleapi.dto.Status;

@Slf4j
@RestController()
@RequestMapping(value = StatusController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class StatusController {
    public static final String REST_URL = "/api/v1/status";

    @GetMapping
    public Status get() throws UnknownHostException {
        log.info("TEST MESSAGE!");
        return new Status(InetAddress.getLocalHost().getHostName(), "Привет!");
    }
}
