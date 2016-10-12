package com.alonmack.drive.repository;

import com.alonmack.car.domain.Car;
import com.alonmack.drive.domain.Drive;
import com.alonmack.racer.domein.Racer;
import org.springframework.stereotype.Repository;

@Repository
public class DriveRepository {

    public void addTime(Racer racer, Car car, float time, float failTime){

    }

    public void create(Racer racer, Car car) {

    }

    public Drive result(Racer racer, Car car) {
        return new Drive();
    }
}
