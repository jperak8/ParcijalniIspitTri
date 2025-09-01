package com.algebra.springapp.controller;

import com.algebra.springapp.model.Upis;
import com.algebra.springapp.service.UpisService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/upisi")
public class UpisController {
    private final UpisService service;
    public UpisController(UpisService service) { this.service = service; }

    @GetMapping
    public List<Upis> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public Upis one(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public Upis create(@Valid @RequestBody Upis u) { return service.save(u); }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Upis update(@PathVariable Long id, @Valid @RequestBody Upis u) {
        u.setUpisId(id);
        return service.save(u);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
