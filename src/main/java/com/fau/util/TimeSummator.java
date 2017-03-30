package com.fau.util;

import lombok.Data;

@Data
public class TimeSummator {
    private long time;
    private long penalty;

    public TimeSummator(long time, long penalty) {
        this.time = time;
        this.penalty = penalty;
    }
}
