package com.fau.competition.domain;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class Competition {

    private int id;
    private LocalDate date;
    private String competitionName;
    private String competitionCity;
    private boolean isActive;
    private LocalTime chipBoard;
    private LocalTime chipFront;
    private LocalTime falseStart;
}
