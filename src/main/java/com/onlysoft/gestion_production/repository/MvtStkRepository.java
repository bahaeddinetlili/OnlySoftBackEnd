package com.onlysoft.gestion_production.repository;

import com.onlysoft.gestion_production.entities.MvtStk;
import com.onlysoft.gestion_production.entities.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MvtStkRepository extends JpaRepository<MvtStk,Integer > {
}
