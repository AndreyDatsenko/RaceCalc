package com.fau.driver.domein;

public class Driver {

    private int id;
    private String name;
    private String surname;
    private int number;
    private String carCategory;
    private String carMark;

    public String getCarCategory() {
        return carCategory;
    }

    public void setCarCategory(String carCategory) {
        this.carCategory = carCategory;
    }

    public String getCarMark() {
        return carMark;
    }

    public void setCarMark(String carMark) {
        this.carMark = carMark;
    }

    public Driver(int id, String name, String surname, int number, String carCategory, String carMark) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.carCategory = carCategory;
        this.carMark = carMark;
    }

    public Driver(String name, String surname, int number, String carCategory, String carMark) {
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.carCategory = carCategory;
        this.carMark = carMark;
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
