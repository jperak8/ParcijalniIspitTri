package com.algebra.springapp.controller;

import com.algebra.springapp.model.Polaznik;
import com.algebra.springapp.service.PolaznikService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/polaznici")
public class PolaznikController {
    private final PolaznikService service;
    public PolaznikController(PolaznikService service) { this.service = service; }

    @GetMapping
    public List<Polaznik> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public Polaznik one(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public Polaznik create(@Valid @RequestBody Polaznik p) { return service.save(p); }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Polaznik update(@PathVariable Long id, @Valid @RequestBody Polaznik p) {
        p.setPolaznikId(id);
        return service.save(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
