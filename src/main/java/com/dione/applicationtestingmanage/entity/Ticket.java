package com.dione.applicationtestingmanage.entity;

import com.dione.applicationtestingmanage.enums.Types;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
    //@JoinColumn(name = "ref_Release_id")
   // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JsonBackReference
    private Release release;

    @ManyToOne
    //@JoinColumn(name = "id_Testeur")
    private Testeur testeur;

    @ManyToOne
   // @JoinColumn(name = "ref_Anomalie_id")
    private Anomalie anomalie;

    @ManyToOne
    //@JoinColumn(name = "refCasTest_id")
    private CasDeTest casDeTest;

}


