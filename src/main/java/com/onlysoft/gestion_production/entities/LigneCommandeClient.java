package com.onlysoft.gestion_production.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lignecommandeclient")
public class LigneCommandeClient extends AbstractEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;

    private Integer Quantite;

    private BigDecimal prixUnitaire;


    @ManyToOne
    @JoinColumn(name = "idcommandeclient")
    private CommandeClient commandeClient;

}
