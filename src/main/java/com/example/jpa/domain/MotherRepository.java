package com.example.jpa.domain;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MotherRepository extends JpaRepository<Mother, Long> {
    @EntityGraph(attributePaths = "daughters")
    List<Mother> findAllWithDaughtersBy();

    @EntityGraph(attributePaths = "sons")
    List<Mother> findAllWithSonsBy();
}
