package com.dione.applicationtestingmanage.entity;

import com.dione.applicationtestingmanage.enums.Types;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Ticket {
    @Id
    private String refTicket;
    private String titre;
    private Types type;
    @ManyToOne(cascade = CascadeType.ALL)
    private Release release;

    @ManyToOne
    private Testeur testeur;

    @OneToOne(cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Anomalie anomalie;

    @ManyToOne
    private CasDeTest casDeTest;
}


