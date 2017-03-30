package com.fau.driver.domain;

import com.fau.lap.domain.Lap;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Driver {

    private int id;
    private String name;
    private String surname;
    private int number;
    private String carCategory;
    private String carMark;
    private List<Lap> laps = new ArrayList<>();
}
