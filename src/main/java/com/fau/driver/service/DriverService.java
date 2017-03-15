package com.fau.driver.service;

import com.fau.driver.domein.Driver;
import com.fau.driver.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@Service
public class DriverService {
    @Autowired
    private DriverRepository driverRepository;

    public List<Driver> getAll(){
        return driverRepository.getAll();
    }

    public void save(Driver driver){
        driverRepository.save(driver);
    }

    public void update(Driver driver){
        driverRepository.update(driver);
    }

    public void delete(int id){
        driverRepository.delete(id);
    }

    public void saveDriversWithResult(Driver driver, LocalTime timeResult) {
        driverRepository.saveDriversWithResult(driver, timeResult);
    }

    public Map<Driver, LocalTime>  getOrderDrivers(){
        return driverRepository.getOrderDrivers();
    }
}
