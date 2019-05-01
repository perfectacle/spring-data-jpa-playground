package com.example.jpa.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MotherTest {
    @Autowired
    private MotherRepository repository;

    @Before
    public void setup() {
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

    @Test
    public void test() {
        var mother = repository.findById(1L);
        mother.ifPresent(mother1 -> mother1.getDaughters()
                                           .forEach(daughter -> System.out.println(daughter.getId())));
    }
}