package com.onlysoft.gestion_production.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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





    @ManyToOne
    @JoinColumn(name = "idcategory")
    @JsonBackReference
    private Category category;


}
