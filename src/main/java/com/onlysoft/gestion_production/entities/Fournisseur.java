package com.onlysoft.gestion_production.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fournisseur")
public class Fournisseur extends AbstractEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")

    private String prenom;

    @Column(name = "mail")
    private String mail;

    @Column(name = "email")

    private  String email;
    @Column(name = "numTel")

    private  String numTel;

    @OneToMany(mappedBy = "fournisseur")
    private List<CommandeFournisseur> commandeFournisseurs;
}
