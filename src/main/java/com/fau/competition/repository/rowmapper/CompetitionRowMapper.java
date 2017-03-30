package com.fau.competition.repository.rowmapper;

import com.fau.competition.domain.Competition;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class CompetitionRowMapper implements RowMapper {

    @Override
    public Competition mapRow(ResultSet rs, int rowNum) throws SQLException {
        Competition competition = new Competition();
        competition.setId(rs.getInt("id"));
        competition.setCompetitionName(rs.getString("name"));
        competition.setDate(LocalDate.parse(rs.getString("date")));
        competition.setCompetitionCity(rs.getString("city"));
        return competition;
    }
}
