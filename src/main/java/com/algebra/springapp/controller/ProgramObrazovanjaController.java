package com.algebra.springapp.controller;

import com.algebra.springapp.model.ProgramObrazovanja;
import com.algebra.springapp.service.ProgramObrazovanjaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programi")
public class ProgramObrazovanjaController {
    private final ProgramObrazovanjaService service;
    public ProgramObrazovanjaController(ProgramObrazovanjaService service) { this.service = service; }

    @GetMapping
    public List<ProgramObrazovanja> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public ProgramObrazovanja one(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public ProgramObrazovanja create(@Valid @RequestBody ProgramObrazovanja p) { return service.save(p); }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ProgramObrazovanja update(@PathVariable Long id, @Valid @RequestBody ProgramObrazovanja p) {
        p.setProgramObrazovanjaId(id);
        return service.save(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
