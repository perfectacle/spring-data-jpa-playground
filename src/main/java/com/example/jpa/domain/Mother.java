package com.example.jpa.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
public class Mother {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "mother", cascade = CascadeType.ALL)
    private Set<Daughter> daughters = new HashSet<>();

    @OneToMany(mappedBy = "mother", cascade = CascadeType.ALL)
    private Set<Son> sons = new HashSet<>();

    @Builder
    public Mother(final Long id, final Set<Daughter> daughters, final Set<Son> sons) {
        this.id = id;

        if(daughters == null) this.daughters = new HashSet<>();
        else {
            daughters.forEach(daughter -> daughter.setMother(this));
            this.daughters = daughters;
        }

        if(sons == null) this.sons = new HashSet<>();
        else {
            sons.forEach(son -> son.setMother(this));
            this.sons = sons;
        }
    }

    public void bearDaughters(final List<Daughter> babyDaughters) {
        babyDaughters.forEach(daughter -> daughter.setMother(this));
        daughters.addAll(babyDaughters);
    }

    public void bearSons(final List<Son> babySons) {
        babySons.forEach(son -> son.setMother(this));
        sons.addAll(babySons);
    }
}
