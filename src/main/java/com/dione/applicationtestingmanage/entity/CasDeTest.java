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

    @OneToMany
    @JoinColumn(name = "ref_Scenario_id")
    private Collection<ScenarioDeTest> scenarioDeTests;

    @OneToMany
    @JoinColumn(name = "ref_Ticket_id")
    private Collection<Ticket> tickets;


}