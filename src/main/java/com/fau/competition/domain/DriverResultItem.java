package com.fau.competition.domain;

import lombok.Data;

@Data
public class DriverResultItem {

    String driverName;

    private long firstLap;
    private long secondLap;
    private long thirdLap;

    private long lap1Penalti1;
    private long lap1Penalti2;
    private long lap1Penalti3;

    private long lap2Penalti1;
    private long lap2Penalti2;
    private long lap2Penalti3;

    private long lap3Penalti1;
    private long lap3Penalti2;
    private long lap3Penalti3;

    private long average;
}
