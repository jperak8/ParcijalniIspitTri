package com.algebra.springapp.service;

import com.algebra.springapp.model.Polaznik;
import com.algebra.springapp.repository.jpa.PolaznikRepository;
import com.algebra.springapp.repository.jdbc.PolaznikJdbcRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PolaznikService {
    private final PolaznikRepository jpaRepo;
    private final PolaznikJdbcRepository jdbcRepo;

    public PolaznikService(PolaznikRepository jpaRepo, PolaznikJdbcRepository jdbcRepo) {
        this.jpaRepo = jpaRepo;
        this.jdbcRepo = jdbcRepo;
    }

    public List<Polaznik> findAll() { return jdbcRepo.findAll(); } // demo: read by JDBC
    public Polaznik findById(Long id) { return jpaRepo.findById(id).orElseThrow(); }
    public Polaznik save(Polaznik p) { return jpaRepo.save(p); }
    public void delete(Long id) { jpaRepo.deleteById(id); }
}
