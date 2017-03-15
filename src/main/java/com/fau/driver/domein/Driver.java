package com.fau.driver.domein;

import com.fau.car.domain.Car;

public class Driver {

    private int id;
    private String name;
    private String surname;
    private int number;
    private Car car;

    public Driver(int id, String name, String surname, int number, Car car) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.car = car;
    }

    public Driver(String name, String surname, int number, Car car) {
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.car = car;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}
