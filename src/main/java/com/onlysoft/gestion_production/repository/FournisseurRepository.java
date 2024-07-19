package com.onlysoft.gestion_production.repository;

import com.onlysoft.gestion_production.entities.Fournisseur;
import com.onlysoft.gestion_production.entities.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer> {
}
