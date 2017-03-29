package com.fau.competition.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class Competition {

    private int id;
    private LocalDate date;
    private String competitionName;
    private String competitionCity;
    private boolean isActive;
    private LocalTime chipBoard;
    private LocalTime chipFront;
    private LocalTime falseStart;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public String getCompetitionCity() {
        return competitionCity;
    }

    public void setCompetitionCity(String competitionCity) {
        this.competitionCity = competitionCity;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public LocalTime getChipBoard() {
        return chipBoard;
    }

    public void setChipBoard(LocalTime chipBoard) {
        this.chipBoard = chipBoard;
    }

    public LocalTime getChipFront() {
        return chipFront;
    }

    public void setChipFront(LocalTime chipFront) {
        this.chipFront = chipFront;
    }

    public LocalTime getFalseStart() {
        return falseStart;
    }

    public void setFalseStart(LocalTime falseStart) {
        this.falseStart = falseStart;
    }
}
