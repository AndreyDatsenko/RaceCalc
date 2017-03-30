package com.fau.util;

import java.util.List;

public class ResultUtil {

    public static long calculateResult(List<TimeSummator> timeArray) {
        return (long) timeArray.stream()
                .sorted()
                .limit(2)
                .mapToLong(l -> l.getTime() + l.getPenalty())
                .average()
                .orElse(0L);
    }
}
