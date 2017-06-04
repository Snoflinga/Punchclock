package com.company;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Created by pernilla on 2017-05-25.
 */
public class PunchClock {
    private boolean logInStatus;
    private LocalDateTime logInTime;
    private LocalDateTime logOutTime;
    private boolean overTime;

    public PunchClock(){
        this.logInStatus = false;
        this.overTime = false;
    }

    public void clockIn(LocalDateTime startTime) {
        if (logInStatus){
            throw new IllegalStateException("Already logged in.");
        }
        this.logInStatus = true;
        this.logInTime = startTime;
    }

    public boolean loggedIn() {
        return logInStatus;
    }

    public void clockOut(LocalDateTime endTime) {
        if (!logInStatus){
            throw new IllegalStateException("Already logged out.");
        }
        this.logInStatus = false;
        this.logOutTime = endTime;
    }

    public LocalDateTime getLogInTime() {
        return this.logInTime;
    }
    public LocalDateTime getLogOutTime() {
        return this.logOutTime;
    }

    public double getOverTime() {
        double minutes = (double) this.logInTime.until(this.logOutTime, ChronoUnit.MINUTES);
        final int WORKDAY = 510;
        double workTime = minutes - WORKDAY;
        if (workTime > 120){
            return workTime * 2;
        } else if (workTime > 0 && workTime < 120){
            return workTime * 1.5;
        }
        return workTime;
    }
}
