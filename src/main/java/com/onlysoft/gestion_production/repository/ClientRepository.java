package com.onlysoft.gestion_production.repository;

import com.onlysoft.gestion_production.entities.Client;
import com.onlysoft.gestion_production.entities.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
