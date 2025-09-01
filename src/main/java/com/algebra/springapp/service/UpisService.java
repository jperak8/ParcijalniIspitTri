package com.algebra.springapp.service;

import com.algebra.springapp.model.Upis;
import com.algebra.springapp.repository.jpa.UpisRepository;
import com.algebra.springapp.repository.jdbc.UpisJdbcRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UpisService {
    private final UpisRepository jpaRepo;
    private final UpisJdbcRepository jdbcRepo;

    public UpisService(UpisRepository jpaRepo, UpisJdbcRepository jdbcRepo) {
        this.jpaRepo = jpaRepo;
        this.jdbcRepo = jdbcRepo;
    }

    public List<Upis> findAll() { return jdbcRepo.findAll(); }
    public Upis findById(Long id) { return jpaRepo.findById(id).orElseThrow(); }
    public Upis save(Upis u) { return jpaRepo.save(u); }
    public void delete(Long id) { jpaRepo.deleteById(id); }
}
