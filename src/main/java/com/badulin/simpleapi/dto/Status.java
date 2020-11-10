package com.badulin.simpleapi.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Status {
    private String hostName;

    public Status(String hostName) {
        this.hostName = hostName;
    }
    public Status() {

    }

}
