package com.dione.applicationtestingmanage.entity;


import com.dione.applicationtestingmanage.enums.Nom;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Testeur {
    @Id
    private String idTesteur;
    private Nom nom;

    @OneToMany(mappedBy = "testeur")
    private Collection<Ticket> tickets;

    @ManyToMany(mappedBy = "testeurs")
    private Collection<Release> releases;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            //name = "cas_De_Test_testeur",
            joinColumns = @JoinColumn(name = "idTesteur"),
            inverseJoinColumns = @JoinColumn(name = "refCasTest")
    )
    private Collection<CasDeTest> casDeTests;

}
