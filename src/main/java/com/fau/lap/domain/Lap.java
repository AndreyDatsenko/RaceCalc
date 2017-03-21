package com.fau.lap.domain;

import java.time.LocalTime;


public class Lap {

    private int number;
    private boolean chipBoard;
    private boolean chipFront;
    private boolean falseStart;
    private LocalTime time;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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

