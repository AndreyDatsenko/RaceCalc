package com.fau.util;

public class TimeSumator {
    private long time;
    private long penalty;

    public TimeSumator(long time, long penalty) {
        this.time = time;
        this.penalty = penalty;
    }

    public long getTime() {
        return time;
    }

    public long getPenalty() {
        return penalty;
    }
}
