package com.algebra.springapp.service;

import com.algebra.springapp.model.ProgramObrazovanja;
import com.algebra.springapp.repository.jpa.ProgramObrazovanjaRepository;
import com.algebra.springapp.repository.jdbc.ProgramObrazovanjaJdbcRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProgramObrazovanjaService {
    private final ProgramObrazovanjaRepository jpaRepo;
    private final ProgramObrazovanjaJdbcRepository jdbcRepo;

    public ProgramObrazovanjaService(ProgramObrazovanjaRepository jpaRepo, ProgramObrazovanjaJdbcRepository jdbcRepo) {
        this.jpaRepo = jpaRepo;
        this.jdbcRepo = jdbcRepo;
    }

    public List<ProgramObrazovanja> findAll() { return jdbcRepo.findAll(); }
    public ProgramObrazovanja findById(Long id) { return jpaRepo.findById(id).orElseThrow(); }
    public ProgramObrazovanja save(ProgramObrazovanja p) { return jpaRepo.save(p); }
    public void delete(Long id) { jpaRepo.deleteById(id); }
}
