package com.fau.lap.domain;

import java.time.LocalTime;

public class Lap {

    private int lapNumber;
    private boolean chipBoard;
    private boolean chipFront;
    private boolean falseStart;
    private LocalTime time;

    public int getLapNumber() {
        return lapNumber;
    }

    public void setLapNumber(int lapNumber) {
        this.lapNumber = lapNumber;
    }

    public boolean isChipBoard() {
        return chipBoard;
    }

    public void setChipBoard(boolean chipBoard) {
        this.chipBoard = chipBoard;
    }

    public boolean isChipFront() {
        return chipFront;
    }

    public void setChipFront(boolean chipFront) {
        this.chipFront = chipFront;
    }

    public boolean isFalseStart() {
        return falseStart;
    }

    public void setFalseStart(boolean falseStart) {
        this.falseStart = falseStart;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}

