package com.onlysoft.gestion_production.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client")
public class Client extends AbstractEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")

    private String prenom;

    //private Adresse addresse;

    @Column(name = "email")

    private  String email;
    @Column(name = "numTel")

    private  String numTel;

    @OneToMany(mappedBy = "client")
    private List<CommandeClient> commandeClients;

    @OneToOne
    private  Adresse adresse;

}
