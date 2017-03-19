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
    public DriverService(DriverRepository driverRepository){
        this.driverRepository = driverRepository;
    }

    public void saveDriver(Driver driver) {
        driverRepository.saveDriver(driver);
    }

    public List<Driver> driverList() {
        return driverRepository.driverList();
    }

    public void deleteDriver(int id) {
        driverRepository.deleteDriver(id);
    }

    public void updateDriver(Driver driver) {
        driverRepository.updateDriver(driver);
    }
}
