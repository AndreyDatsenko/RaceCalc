package com.alonmack.drive.domain;

import com.alonmack.car.domain.Car;
import com.alonmack.racer.domein.Racer;

public class Drive {

    private Car car;
    private Racer racer;

    private float time;
    private float failTime;
    private float result;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Racer getRacer() {
        return racer;
    }

    public void setRacer(Racer racer) {
        this.racer = racer;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public float getFailTime() {
        return failTime;
    }

    public void setFailTime(float failTime) {
        this.failTime = failTime;
    }

    public float getResult() {
        return result;
    }

    public void setResult(float result) {
        this.result = result;
    }

}

