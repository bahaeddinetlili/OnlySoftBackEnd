package com.onlysoft.gestion_production.services;

import com.onlysoft.gestion_production.entities.Category;

import java.util.List;

public interface CategoryService {

    Category save(Category category);

    Category findById(Integer id);

    List<Category> findAll();

    void delete(Integer id);
}
