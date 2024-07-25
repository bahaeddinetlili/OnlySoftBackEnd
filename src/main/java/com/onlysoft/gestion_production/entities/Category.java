package com.onlysoft.gestion_production.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "category")
public class Category  extends  AbstractEntity{

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "code")
    private String code;

    @Column(name = "designation")
    private String designation;


    @OneToMany(mappedBy = "category")
    @JsonManagedReference
    private List<Article> articles;


}
