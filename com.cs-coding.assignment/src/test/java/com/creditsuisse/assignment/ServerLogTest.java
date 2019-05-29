package com.creditsuisse.assignment;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ServerLogTest {

    private ServerLog testLog;
    private static int counter = 1;

    @org.junit.Before
    public void setup() {
        testLog = new ServerLog("scsmbstgrxyz", "STARTED",
                1491377495212L, "123", "APPLICATION_LOG");
        System.out.println("Running a test nr: " + counter + " from a: " + this.getClass().getSimpleName());
        counter++;
    }

    @Test
    public void getLogInputDate() {
        LocalDateTime time = testLog.getLogInputDate();
        assertEquals(time, testLog.convertMillisecondsIntoDate(testLog.getTimestamp()));
    }

    @Test
    public void getLogInputDate_ForDefault() {
        ServerLog testLog = new ServerLog(null, null,
                0, null, null);
        LocalDateTime time = testLog.getLogInputDate();
        assertEquals(time, testLog.convertMillisecondsIntoDate(testLog.getTimestamp()));
    }

    @Test
    public void isAlertFlag() {
        assertFalse("The ending eventLog still has not been executed", testLog.isAlertFlag());
    }
}