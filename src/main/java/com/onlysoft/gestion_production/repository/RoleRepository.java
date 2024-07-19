package com.onlysoft.gestion_production.repository;

import com.onlysoft.gestion_production.entities.Role;
import com.onlysoft.gestion_production.entities.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
