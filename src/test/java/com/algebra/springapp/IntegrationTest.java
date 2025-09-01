package com.algebra.springapp;

import com.algebra.springapp.model.Polaznik;
import com.algebra.springapp.repository.jpa.PolaznikRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class IntegrationTest {

    @Autowired
    private PolaznikRepository polaznikRepository;

    @Test
    void contextAndJpaWorks() {
        Polaznik p = new Polaznik();
        p.setIme("Ivan"); p.setPrezime("Markovic");
        Polaznik saved = polaznikRepository.save(p);
        assertThat(saved.getPolaznikId()).isNotNull();
        assertThat(polaznikRepository.findById(saved.getPolaznikId())).isPresent();
    }
}
