package com.badulin.simpleapi.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class StatusTest {

    @Test
    void getHostName() {
        Status status = new Status("test-hostname");

        String result = status.getHostName();
        Assertions.assertEquals(result, "test-hostname", "The hostname is similar");
    }

    @Test
    void setHostName() {
        Status status = new Status("test-hostname");

        status.setHostName("set-test");
        Assertions.assertNotEquals(status, "test-hostname", "The hostname is similar");
    }

    @Test
    void testEquals() {
        Status st1 = new Status("test-hostname");
        Status st2 = new Status("test-hostname");

        assertTrue(st1.equals(st2));
    }

    @Test
    void testHashCode() {
        Status st1 = new Status("test-hostname");
        Status st2 = new Status("test-hostname");
        assertTrue(st1.hashCode() == st2.hashCode());

    }

    @Test
    void testToString() {
        
    }
}