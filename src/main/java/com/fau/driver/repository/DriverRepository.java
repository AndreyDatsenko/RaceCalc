package com.fau.driver.repository;

import com.fau.driver.domein.Driver;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


@Repository
public class DriverRepository {

    private final AtomicInteger idGenerator = new AtomicInteger();
    private List<Driver> drivers = new ArrayList<>();

    private Map<Driver, Long> orderDrivers = new HashMap<>();

    public List<Driver> getAll() {
        return drivers;
    }

    public Driver find(int id) {
        for (Driver driver : drivers) {
            if (id == driver.getId()) {
                return driver;
            }
        }
        return null;
    }

    public void save(Driver driver) {
        Integer id = idGenerator.incrementAndGet();
        driver.setId(id);
        drivers.add(driver);
    }

    public void update(Driver driver) {
        Integer id = driver.getId();
        Driver userToUpdate = find(id);
        userToUpdate.setName(driver.getName());
        userToUpdate.setSurname(driver.getSurname());
        userToUpdate.setNumber(driver.getNumber());
        userToUpdate.setCar(driver.getCar());
        drivers.set(id - 1, driver);

    }

    public void delete(int id) {
        Driver driverToDelete = null;
        for (Driver driver : drivers) {
            if (id == driver.getId()) {
                driverToDelete = driver;
                break;
            }
        }
        drivers.remove(driverToDelete);
    }

    public void saveDriversWithResult(Driver driver, LocalTime timeResult) {
        Long time = timeResult.toNanoOfDay();
        orderDrivers.put(driver, time);
    }

    public Map<Driver, LocalTime> getOrderDrivers() {

        return orderDrivers.entrySet().stream()
                .sorted(Map.Entry.<Driver, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> LocalTime.ofNanoOfDay(e.getValue())));

    }
}
