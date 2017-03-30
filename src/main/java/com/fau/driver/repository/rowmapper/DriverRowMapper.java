package com.fau.driver.repository.rowmapper;

import com.fau.driver.domain.Driver;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DriverRowMapper implements RowMapper<Driver> {

    @Override
    public Driver mapRow(ResultSet rs, int rowNum) throws SQLException {
        Driver driver = new Driver();
        driver.setId(rs.getInt("id"));
        driver.setName(rs.getString("name"));
        driver.setSurname(rs.getString("surname"));
        driver.setNumber(rs.getInt("number"));
        driver.setCarCategory(rs.getString("car_category"));
        driver.setCarMark(rs.getString("car_mark"));

        return driver;
    }
}
