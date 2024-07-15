package com.onlysoft.gestion_production.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
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



}
