package com.fau.lap.repository;

import com.fau.lap.rowmapper.LapRowMapper;
import com.fau.lap.domain.Lap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class LapRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public LapRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void saveQualificationLap(Lap lap, int driverID) {
        Object[] params = new Object[]{driverID, lap.getLapNumber(), lap.getTime().toNanoOfDay()};
        String sql = "INSERT INTO lap(driver_id, lap_number, time) VALUES(?, ?, ?)";
        jdbcTemplate.update(sql, params);
    }
    
    public List<Lap> getLapsByDriverId(int driverId){
        Object[] param = new Object[]{driverId};
        String sql = "SELECT * FROM lap WHERE driver_id = ?";
        
        return jdbcTemplate.query(sql, param, new LapRowMapper());
    }

}
