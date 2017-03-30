package com.fau.lap.repository;

import com.fau.lap.repository.rowmapper.LapRowMapper;
import com.fau.lap.domain.Lap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class LapRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LapRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void saveQualificationLap(Lap lap, int driverID) {
        Object[] params = new Object[]{driverID, lap.getLapNumber(), lap.getTime().toNanoOfDay(),
                lap.isChipBoard(), lap.isChipFront(), lap.isFalseStart()};
        String saveQualificationLap = "INSERT INTO lap(driver_id, lap_number, time, chip_board, chip_front, false_start) VALUES(?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(saveQualificationLap, params);
    }

    public List<Lap> getLaps() {
        String getLaps = "SELECT * FROM lap";
        return jdbcTemplate.query(getLaps, new LapRowMapper());
    }
}
