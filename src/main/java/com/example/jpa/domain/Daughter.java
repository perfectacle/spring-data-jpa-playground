package com.example.jpa.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Daughter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @Setter
    private Mother mother;

    @Builder
    public Daughter(final Long id, final Mother mother) {
        this.id = id;
        this.mother = mother;
    }
}
