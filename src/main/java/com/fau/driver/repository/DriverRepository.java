package com.fau.driver.repository;

import com.fau.driver.domein.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public void saveDriver(Driver driver) {
        Map<String, Object> parameters = new HashMap<>(6);
        parameters.put("number", driver.getNumber());
        parameters.put("name", driver.getName());
        parameters.put("surname", driver.getSurname());
        parameters.put("car_category", driver.getCarCategory());
        parameters.put("car_mark", driver.getCarMark());
        Number newId = insertDriver.executeAndReturnKey(parameters);
        driver.setId(newId.intValue());

        addToCompetitionDriver(newId.intValue());
    }

    public void addToCompetitionDriver(int driverId) {
        Object[] params = new Object[]{getCompetitionId(), driverId};
        String sql = "INSERT INTO competition_driver (competition_id, driver_id) VALUES(?, ?)";

        jdbcTemplate.update(sql, params);
    }

    public int getCompetitionId() {
        String sql = "SELECT id FROM competition WHERE is_active = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{true}, Integer.class);
    }

    public List<Driver> driverList() {
        Object[] param = new Object[]{getCompetitionId()};
        String sql = "SELECT * FROM driver d\n" +
                "JOIN competition_driver cd ON d.id = cd.driver_id\n" +
                "AND cd.competition_id=?";

        return jdbcTemplate.query(sql, param, (rs, rowNum) -> {
            Driver driver = new Driver(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getString(5),
                    rs.getString(6)
            );
            return driver;
        });
    }

    public void deleteDriver(int id) {
        Object[] param = new Object[]{id};
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


}
