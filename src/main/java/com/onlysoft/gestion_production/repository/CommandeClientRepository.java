package com.onlysoft.gestion_production.repository;

import com.onlysoft.gestion_production.entities.CommandeClient;
import com.onlysoft.gestion_production.entities.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommandeClientRepository extends JpaRepository<CommandeClient, Integer> {

    Optional<CommandeClient> findCommandeClientByCode(String code);

    List<CommandeClient> findAllByClientId(Integer id);
}
