package com.example.jpa;

import com.example.jpa.domain.Daughter;
import com.example.jpa.domain.Mother;
import com.example.jpa.domain.MotherRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class JpaApplication {
    private final MotherRepository repository;

    public JpaApplication(final MotherRepository repository) {
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @PostConstruct
    public void post() {
        final var motherA = Mother.builder().build();
        final var daughterAA = Daughter.builder().build();
        final var daughterAB = Daughter.builder().build();
        final var daughterAC = Daughter.builder().build();
        motherA.bearDaughters(List.of(daughterAA, daughterAB, daughterAC));

        final var motherB = Mother.builder().build();
        final var daughterBA = Daughter.builder().build();
        final var daughterBB = Daughter.builder().build();
        final var daughterBC = Daughter.builder().build();
        motherB.bearDaughters(List.of(daughterBA, daughterBB, daughterBC));

        repository.saveAll(List.of(motherA, motherB));
    }
}
