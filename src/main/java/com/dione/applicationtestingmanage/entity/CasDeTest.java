package com.dione.applicationtestingmanage.entity;


import com.dione.applicationtestingmanage.enums.Resultat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class CasDeTest {
    @Id
    private String refCasTest;
    @Enumerated(EnumType.STRING)
    @Column(length = 15)
    private Resultat resultat;
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private Collection<ScenarioDeTest> scenarioDeTests;

    @OneToMany(mappedBy = "casDeTest")
    private Collection<Ticket> tickets;

    @ManyToMany
    private Collection<Testeur> testeur;
}
