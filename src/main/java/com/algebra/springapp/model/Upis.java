package com.algebra.springapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Upis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long upisId;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "idPolaznik", nullable = false)
    @NotNull
    private Polaznik polaznik;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "idProgramObrazovanja", nullable = false)
    @NotNull
    private ProgramObrazovanja programObrazovanja;
}
