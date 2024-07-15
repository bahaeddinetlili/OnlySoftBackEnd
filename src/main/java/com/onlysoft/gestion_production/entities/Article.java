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
@Table(name = "article")
public class Article extends AbstractEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "codearticle")
    private String codeArticle;

    @Column(name = "designation")
    private String Designation;


    @Column(name = "prixunitaireht")
    private BigDecimal prixUnitaireHt;


    @Column(name = "tauxtva")
    private BigDecimal tauxTva;

    @Column(name = "prixunitairettc")
    private BigDecimal prixUnitaireTtc;



    private  String photo;


    @ManyToOne
    @JoinColumn(name = "idcategory")
    private Category category;

}
