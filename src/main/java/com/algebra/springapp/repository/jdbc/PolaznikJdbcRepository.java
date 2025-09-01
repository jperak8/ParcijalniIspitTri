package com.algebra.springapp.repository.jdbc;

import com.algebra.springapp.model.Polaznik;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class PolaznikJdbcRepository {
    private final JdbcTemplate jdbcTemplate;
    public PolaznikJdbcRepository(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    private static final RowMapper<Polaznik> MAPPER = (rs, i) -> {
        Polaznik p = new Polaznik();
        p.setPolaznikId(rs.getLong("PolaznikID"));
        p.setIme(rs.getString("Ime"));
        p.setPrezime(rs.getString("Prezime"));
        return p;
    };

    public List<Polaznik> findAll() {
        return jdbcTemplate.query("SELECT PolaznikID, Ime, Prezime FROM Polaznik", MAPPER);
    }
}
