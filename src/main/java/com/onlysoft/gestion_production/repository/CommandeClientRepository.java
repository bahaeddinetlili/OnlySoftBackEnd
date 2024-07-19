package com.onlysoft.gestion_production.repository;

import com.onlysoft.gestion_production.entities.CommandeClient;
import com.onlysoft.gestion_production.entities.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeClientRepository extends JpaRepository<CommandeClient, Integer> {
}
