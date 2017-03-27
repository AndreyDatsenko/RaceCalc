package com.fau.driver.service;

import com.fau.driver.domein.Driver;
import com.fau.driver.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    private DriverRepository driverRepository;

    @Autowired
    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public void createDriver(int competitionId, Driver driver) {
        driverRepository.createDriver(competitionId, driver);
    }

    public List<Driver> driverList(int competitionId) {
        return driverRepository.driverList(competitionId);
    }

    public void deleteDriver(int driverId) {
        driverRepository.deleteDriver(driverId);
    }

    public List<Driver> getResultDriverList(int competitionId) {
        return driverRepository.getResultDriverList(competitionId);
    }

    public void updateDriver(Driver driver) {
        driverRepository.updateDriver(driver);
    }

    public Driver getDriverById(int driverId) {
        return driverRepository.getDriverById(driverId);
    }
}
