package com.fau.car.domain;

public class Car {

    private String category;
    private String mark;

    public Car(String category, String mark) {
        this.category = category;
        this.mark = mark;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
