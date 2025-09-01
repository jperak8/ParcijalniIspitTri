package com.algebra.springapp.repository.jdbc;

import com.algebra.springapp.model.Upis;
import com.algebra.springapp.model.Polaznik;
import com.algebra.springapp.model.ProgramObrazovanja;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UpisJdbcRepository {
    private final JdbcTemplate jdbcTemplate;
    public UpisJdbcRepository(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    private static final RowMapper<Upis> MAPPER = (rs, i) -> {
        Upis u = new Upis();
        u.setUpisId(rs.getLong("UpisId"));
        Polaznik p = new Polaznik();
        p.setPolaznikId(rs.getLong("IDPolaznik"));
        u.setPolaznik(p);
        ProgramObrazovanja po = new ProgramObrazovanja();
        po.setProgramObrazovanjaId(rs.getLong("IDProgramObrazovanja"));
        u.setProgramObrazovanja(po);
        return u;
    };

    public List<Upis> findAll() {
        return jdbcTemplate.query("SELECT UpisId, IDPolaznik, IDProgramObrazovanja FROM Upis", MAPPER);
    }
}
