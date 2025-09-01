package com.algebra.springapp.repository.jdbc;

import com.algebra.springapp.model.ProgramObrazovanja;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ProgramObrazovanjaJdbcRepository {
    private final JdbcTemplate jdbcTemplate;
    public ProgramObrazovanjaJdbcRepository(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    private static final RowMapper<ProgramObrazovanja> MAPPER = (rs, i) -> {
        ProgramObrazovanja p = new ProgramObrazovanja();
        p.setProgramObrazovanjaId(rs.getLong("ProgramObrazovanjaId"));
        p.setNaziv(rs.getString("Naziv"));
        p.setCsvet(rs.getString("CSVET"));
        return p;
    };

    public List<ProgramObrazovanja> findAll() {
        return jdbcTemplate.query("SELECT ProgramObrazovanjaId, Naziv, CSVET FROM ProgramObrazovanja", MAPPER);
    }
}
