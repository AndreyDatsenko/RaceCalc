package com.fau.driver.repository;

import com.fau.driver.rowmapper.DriverRowMapper;
import com.fau.driver.domein.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DriverRepository {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert insertDriver;

    @Autowired
    public DriverRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.insertDriver = new SimpleJdbcInsert(dataSource)
                .usingGeneratedKeyColumns("id")
                .withTableName("driver");
    }

    public void createDriver(int competitionId, Driver driver) {
        Map<String, Object> parameters = new HashMap<>(6);
        parameters.put("number", driver.getNumber());
        parameters.put("name", driver.getName());
        parameters.put("surname", driver.getSurname());
        parameters.put("car_category", driver.getCarCategory());
        parameters.put("car_mark", driver.getCarMark());
        Number newId = insertDriver.executeAndReturnKey(parameters);
        driver.setId(newId.intValue());

        addDriverToCompetition(competitionId, newId.intValue());
    }

    public void addDriverToCompetition(int competitionId, int driverId) {
        Object[] params = new Object[]{competitionId, driverId};
        String sql = "INSERT INTO competition_driver (competition_id, driver_id) VALUES(?, ?)";

        jdbcTemplate.update(sql, params);
    }

    public List<Driver> driverList(int competitionId) {
        Object[] param = new Object[]{competitionId};
        String sql = "SELECT * FROM driver d\n" +
                "JOIN competition_driver cd ON d.id = cd.driver_id\n" +
                "AND cd.competition_id=?";

        return jdbcTemplate.query(sql, param, new DriverRowMapper());
    }

    public void deleteDriver(int driverId) {
        Object[] param = new Object[]{driverId};
        String deleteFromCompetitionDriver = "DELETE FROM competition_driver WHERE driver_id=?";
        String deleteFromDriver = "DELETE FROM driver WHERE id=?";
        jdbcTemplate.update(deleteFromCompetitionDriver, param);
        jdbcTemplate.update(deleteFromDriver, param);
    }

    public void updateDriver(Driver driver) {
        Object[] params = new Object[]{driver.getName(), driver.getSurname(), driver.getNumber(),
                driver.getCarCategory(), driver.getCarMark(), driver.getId()};
        String sql = "UPDATE driver SET name = ?, surname = ?, number = ?, car_category = ?, car_mark = ? WHERE id = ?";
        jdbcTemplate.update(sql, params);
    }

    public List<Driver> getResultDriverList(int competitionId) {
        Object[] param = new Object[]{competitionId};
        String sql = "SELECT * FROM driver d\n" +
                "JOIN competition_driver cd ON d.id = cd.driver_id\n" +
                "JOIN lap lp ON lp.driver_id = d.id AND cd.competition_id=? AND lp.lap_number=0\n" +
                "ORDER BY lp.time";

        return jdbcTemplate.query(sql, param, new DriverRowMapper());
    }

    public Driver getDriverById(int driverId) {
        Object[] param = new Object[]{driverId};
        String sql = "SELECT * FROM driver WHERE id = ?";

        return jdbcTemplate.queryForObject(sql, param, new DriverRowMapper());
    }
}
