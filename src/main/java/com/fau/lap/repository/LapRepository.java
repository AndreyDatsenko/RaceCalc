package com.fau.lap.repository;

import com.fau.lap.domain.Lap;
import com.fau.driver.domein.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class LapRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public LapRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void addTime(Driver driver, float time, float failTime) {

    }

    public void saveQualificationLap(Lap lap, int driverID) {
        Object[] params = new Object[]{driverID, lap.getNumber(), lap.getTime().toNanoOfDay()};
        String sql = "INSERT INTO lap(driver_id, lap_number, time) VALUES(?, ?, ?)";
        jdbcTemplate.update(sql, params);
    }

    public Lap result(Driver driver) {
        return new Lap();
    }
}
