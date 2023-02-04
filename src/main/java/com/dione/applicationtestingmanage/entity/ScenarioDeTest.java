package com.dione.applicationtestingmanage.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class ScenarioDeTest {
    @Id
    private String refScenario;
    @Column(length = 300)
    private String scenario;

    @ManyToOne
    private CasDeTest casDeTest;
}
