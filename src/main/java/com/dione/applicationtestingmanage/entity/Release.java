package com.dione.applicationtestingmanage.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Release {

    @Id
    private String refRelease;
    @Temporal(TemporalType.DATE)
    private Date dateLivraison;

    @Temporal(TemporalType.DATE)
    private Date datePrevision;

    @Temporal(TemporalType.DATE)
    private Date dateReelle;

    /*Cela signifie que si toute fois une release est supprimée,
    le ticket deviendra ophelin et sera détruit sur le coup
     */
    @OneToMany(mappedBy = "release"
/*            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER */)
    private Collection<Ticket> tickets;

}
