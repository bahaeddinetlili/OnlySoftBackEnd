package com.onlysoft.gestion_production.repository;

import com.onlysoft.gestion_production.entities.Entreprise;
import com.onlysoft.gestion_production.entities.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {
}
