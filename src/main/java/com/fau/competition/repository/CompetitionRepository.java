package com.fau.competition.repository;

import com.fau.competition.domein.Competition;
import com.fau.driver.domein.Driver;
import com.fau.lap.domain.Lap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Date;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CompetitionRepository {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert insertCompetition;

    @Autowired
    public CompetitionRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.insertCompetition = new SimpleJdbcInsert(dataSource)
                .withTableName("competition")
                .usingGeneratedKeyColumns("id");
    }

    public int createCompetition(Competition competition) {
        Map<String, Object> parameters = new HashMap<>(8);
        parameters.put("name", competition.getCompetitionName());
        parameters.put("date", Date.valueOf(competition.getDate()));
        parameters.put("city", competition.getCompetitionCity());
        parameters.put("is_active", competition.isActive());
        parameters.put("chip_board", competition.getChipBoard().toNanoOfDay());
        parameters.put("chip_front", competition.getChipFront().toNanoOfDay());
        parameters.put("false_start", competition.getFalseStart().toNanoOfDay());
        Number newId = insertCompetition.executeAndReturnKey(parameters);
        competition.setId(newId.intValue());
        
        return newId.intValue();
    }

    public void closeCompetition() {
        jdbcTemplate.update("UPDATE Competition SET is_active=FALSE WHERE is_active = TRUE");
    }
    public List<Driver> getResultQualificationList(int competitionId) {
        Object[] param = new Object[]{competitionId};
        String sql = "SELECT d.id, d.name, d.surname, d.number, d.car_category, d.car_mark, lp.lap_number, lp.time\n" +
                "FROM driver d\n" +
                "JOIN competition_driver cd ON d.id = cd.driver_id\n" +
                "JOIN lap lp ON lp.driver_id = d.id AND cd.competition_id=?\n" +
                "ORDER BY lp.time";

        return jdbcTemplate.query(sql, param, (rs, rowNum) -> {
            List<Lap> laps = new ArrayList<>();

            Driver driver = new Driver();
            driver.setId(rs.getInt("id"));
            driver.setName(rs.getString("name"));
            driver.setSurname(rs.getString("surname"));
            driver.setNumber(rs.getInt("number"));
            driver.setCarCategory(rs.getString("car_category"));
            driver.setCarMark(rs.getString("car_mark"));

            Lap lap = new Lap();
            lap.setLapNumber(rs.getInt("lap_number"));
            lap.setTime(LocalTime.ofNanoOfDay(rs.getLong("time")));
            laps.add(lap);
            driver.setLaps(laps);

            return driver;
        });
    }

}
