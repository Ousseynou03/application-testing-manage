package com.dione.applicationtestingmanage.entity;


import com.dione.applicationtestingmanage.enums.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Anomalie {
    @Id
    private String refAnomalie;
    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private Criticite criticite;
    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private Priorite priorite;
    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private Statut statut;
    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private EnCours enCours;
    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private Cloturee cloturee;

    @OneToMany
    //@JoinColumn(name = "ref_Ticket_id")
    private Collection<Ticket> tickets;


}
