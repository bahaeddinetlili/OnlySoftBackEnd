package com.onlysoft.gestion_production.repository;

import com.onlysoft.gestion_production.entities.LigneCommandeClient;
import com.onlysoft.gestion_production.entities.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LigneCommandeClientRepository extends JpaRepository<LigneCommandeClient,Integer > {
    List<LigneCommandeClient> findAllByCommandeClientId(Integer id);

    List<LigneCommandeClient> findAllByArticleId(Integer id);
}
