package com.alonmack.drive.service;

import com.alonmack.car.domain.Car;
import com.alonmack.drive.domain.Drive;
import com.alonmack.drive.repository.DriveRepository;
import com.alonmack.racer.domein.Racer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriveService {

    @Autowired
    private DriveRepository driveRepository;

    public void addTime(Racer racer, Car car, float time, float failTime){
        driveRepository.addTime(racer, car, time, failTime);

    }

    public void create(Racer racer, Car car) {

        driveRepository.create(racer, car);
    }

    public Drive result(Racer racer, Car car) {
        return driveRepository.result(racer, car);

    }
}
