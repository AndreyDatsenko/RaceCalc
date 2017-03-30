package com.fau.competition.repository;

import com.fau.competition.domain.Competition;
import com.fau.competition.repository.rowmapper.CompetitionRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CompetitionRepository {

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert insertCompetition;

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

    public List<Competition> getActiveCompetitions() {
        String listCompetition = "SELECT * FROM competition WHERE is_active = TRUE";
        return jdbcTemplate.query(listCompetition, new CompetitionRowMapper());
    }

    public List<Competition> searchByCity(String city) {
        Object[] param = new Object[]{city};
        String citySearch = "SELECT * FROM competition WHERE city = ?";
        return jdbcTemplate.query(citySearch, param, new CompetitionRowMapper());
    }
}
