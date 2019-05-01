package com.example.jpa.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MotherTest {
    @Autowired
    private MotherRepository repository;

    @Test
    public void test() {
        repository.findById(1L).ifPresent(mother -> mother.getDaughters().size());
    }
}