package com.onlysoft.gestion_production.repository;

import com.onlysoft.gestion_production.entities.Category;
import com.onlysoft.gestion_production.entities.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Integer > {
    Optional<Category> findById(Integer id);

}
