package com.dione.applicationtestingmanage.entity;

import com.dione.applicationtestingmanage.enums.Types;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Ticket {
    @Id
    private String refTicket;
    private String titre;
    private Types type;
    @ManyToOne
    private Release release;

    @ManyToOne
    private Testeur testeur;

    @OneToOne
    private Anomalie anomalie;

    @ManyToOne
    private CasDeTest casDeTest;

    @ManyToOne
    private Anomalie anom;
}


