package com.example.jpa.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Mother {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "mother", cascade = CascadeType.ALL)
    private List<Daughter> daughters = new ArrayList<>();

    @Builder
    public Mother(final Long id, final List<Daughter> daughters) {
        this.id = id;

        if(daughters == null) this.daughters = new ArrayList<>();
        else {
            daughters.forEach(daughter -> daughter.setMother(this));
            this.daughters = daughters;
        }
    }

    public void bearDaughters(final List<Daughter> babyDaughters) {
        babyDaughters.forEach(daughter -> daughter.setMother(this));
        daughters.addAll(babyDaughters);
    }
}
