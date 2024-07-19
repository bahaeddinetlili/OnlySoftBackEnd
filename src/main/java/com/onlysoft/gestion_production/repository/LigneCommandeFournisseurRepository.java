package com.onlysoft.gestion_production.repository;

import com.onlysoft.gestion_production.entities.CommandeFournisseur;
import com.onlysoft.gestion_production.entities.LigneCommandeFournisseur;
import com.onlysoft.gestion_production.entities.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommandeFournisseurRepository extends JpaRepository<LigneCommandeFournisseur,Integer > {
}
