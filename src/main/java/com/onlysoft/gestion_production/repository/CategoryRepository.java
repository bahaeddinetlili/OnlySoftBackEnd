package com.onlysoft.gestion_production.repository;

import com.onlysoft.gestion_production.entities.Category;
import com.onlysoft.gestion_production.entities.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer > {
}
