package com.badulin.simpleapi.dto;

import lombok.Data;

@Data
public class Status {
    private String hostName;
    public String getHostName() {
        return hostName;
    }


    public Status(String hostName) {
        this.hostName = hostName;
    }
    public Status() {

    }

}
