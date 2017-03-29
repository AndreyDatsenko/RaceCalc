package com.fau.lap.rowmapper;

import com.fau.lap.domain.Lap;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

public class LapRowMapper implements RowMapper<Lap> {
    @Override
    public Lap mapRow(ResultSet rs, int rowNum) throws SQLException {
        Lap lap = new Lap();
        lap.setLapNumber(rs.getInt("lap_number"));
        lap.setLapNumber(rs.getInt("lap_number"));
        lap.setChipBoard(rs.getBoolean("chip_board"));
        lap.setChipFront(rs.getBoolean("chip_front"));
        lap.setFalseStart(rs.getBoolean("false_start"));
        lap.setTime(LocalTime.ofNanoOfDay(rs.getLong("time")));

        return lap;
    }
}
