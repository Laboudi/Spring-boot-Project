package com.architeo.ehiringapp.Model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Candidate {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String profil;
    private String entrepriseActuel;
    private double salaireActuel;
    private double pretentionSalaire;
    private String contrat;
    private int anciennete;
    private String ville;
    @Lob
    private byte[] cv;
    private String FileName;
    private String preselection;
    private String decisionRh;
    private String decisionTech;
    private String decisionFinal;
    private String comment;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(
            name = "Candidate_client",
            joinColumns = @JoinColumn(name = "candidate_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id"))
    private Set<Client> clients;
}
