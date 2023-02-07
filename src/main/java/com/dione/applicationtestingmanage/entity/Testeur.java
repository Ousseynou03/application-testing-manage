package com.dione.applicationtestingmanage.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Testeur {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTesteur;
    private String nom;
    private String prenom;

    @OneToMany(mappedBy = "testeur")
    //@JoinColumn(name = "id_Ticket")
    private Collection<Ticket> tickets;
}
