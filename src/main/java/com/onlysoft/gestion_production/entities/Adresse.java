package com.onlysoft.gestion_production.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "adresse")
public class Adresse extends AbstractEntity {


    @Column(name = "adresse")
    private String adresse;

    @Column(name = "ville")

    private String ville;
    @Column(name = "codepostale")

    private String codePostale;

    @Column(name = "pays")

    private String pays;

    @OneToOne(mappedBy = "adresse")
    private Client client;








}
