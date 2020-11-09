package com.badulin.simpleapi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Status {
    private String hostName;
    private String helloWord;

    public String getHostName() {
        return hostName;
    }

    public String testMsg() {
        return "test msg";
    }
}
