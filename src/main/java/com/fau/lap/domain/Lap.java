package com.fau.lap.domain;


import java.time.LocalTime;
import java.util.*;

public class Lap {

    private List<LocalTime> times = new ArrayList<>();
    private Map<String, LocalTime> penalties = new HashMap<>();
    private LocalTime result;

    public List<LocalTime> getTimes() {
        return times;
    }

    public void setTimes(List<LocalTime> times) {
        this.times = times;
    }

    public Map<String, LocalTime> getPenalties() {
        return penalties;
    }

    public void setPenaltyes(Map<String, LocalTime> penalties) {
        this.penalties = penalties;
    }

    public LocalTime getResult() {
        return result;
    }

    public void setResult(LocalTime result) {
        this.result = result;
    }
}

