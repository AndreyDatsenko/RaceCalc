package com.fau.lap.domain;

import lombok.Data;

import java.time.LocalTime;

@Data
public class Lap {

    private int driver_id;
    private int lapNumber;
    private boolean chipBoard;
    private boolean chipFront;
    private boolean falseStart;
    private LocalTime time;
}

