package com.company;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import static org.junit.Assert.*;

/**
 * Created by pernilla on 2017-05-25.
 */
public class PunchClockTest {
    private PunchClock punchClock;

    @Before
    public void setUp(){
        this.punchClock = new PunchClock();
    }
    @Test
    public void testClockInChangesLogInStatus(){
        LocalDateTime localDateTime = LocalDateTime.now();
        punchClock.clockIn(localDateTime);
        assertTrue("Not logged in", punchClock.loggedIn());
    }
    @Test(expected = IllegalStateException.class)
    public void testClockInStatusWhenAlreadyLoggedInThrowsException(){
        LocalDateTime localDateTime = LocalDateTime.now();
        punchClock.clockIn(localDateTime);
        punchClock.clockIn(localDateTime);
    }
    @Test
    public void testClockOutChangesLogInStatus(){
        LocalDateTime localDateTime = LocalDateTime.now();
        punchClock.clockIn(localDateTime);
        punchClock.clockOut(localDateTime);
        assertFalse("Not logged out", punchClock.loggedIn());
    }
    @Test (expected = IllegalStateException.class)
    public void testClockOutStatusWhenAlreadyLoggedOutThrowsException(){
        LocalDateTime localDateTime = LocalDateTime.now();
        punchClock.clockIn(localDateTime);
        punchClock.clockOut(localDateTime);
        punchClock.clockOut(localDateTime);
    }
    @Test
    public void testGetLogInTime(){
        LocalDateTime baseline = LocalDateTime.of(2017, 5, 27, 20, 38);
        punchClock.clockIn(baseline);
        LocalDateTime actual = punchClock.getLogInTime();
        assertEquals("Timestamp don't match", baseline, actual);
    }
    @Test
    public void testGetLogOutTime(){
        LocalDateTime baseline = LocalDateTime.of(2017, 5, 27, 20, 36);
        punchClock.clockIn(LocalDateTime.of(2017, 5, 27, 18, 35));
        punchClock.clockOut(LocalDateTime.of(2017, 5, 27, 20, 36));
        LocalDateTime actual = punchClock.getLogOutTime();
        assertEquals("Timestamp don't match", baseline, actual);
    }
    @Test
    public void testGetOvertimeExpectedNone(){
        punchClock.clockIn(LocalDateTime.of(2017, 5, 27, 8, 0));
        punchClock.clockOut(LocalDateTime.of(2017, 5, 27, 16,30));
        long expected = 0;
        assertEquals("Overtime value isn't accurate", expected, punchClock.getOverTime(),1E-6);
    }
    @Test
    public void testGetOvertimeExpectedPlus(){
        punchClock.clockIn(LocalDateTime.of(2017, 5, 27, 7, 50));
        punchClock.clockOut(LocalDateTime.of(2017, 5, 27, 16,30));
        double expected = 10 * 1.5;
        assertEquals("Overtime value isn't accurate", expected, punchClock.getOverTime(), 1E-6);
    }
}