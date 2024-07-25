package com.onlysoft.gestion_production.services.Impl;

import com.onlysoft.gestion_production.entities.Category;
import com.onlysoft.gestion_production.exception.EntityNotFoundException;
import com.onlysoft.gestion_production.exception.ErrorCodes;
import com.onlysoft.gestion_production.repository.CategoryRepository;
import com.onlysoft.gestion_production.services.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category save(Category category) {
        // Add validation if needed
        return categoryRepository.save(category);
    }

    @Override
    public Category findById(Integer id) {
        if (id == null) {
            log.error("Category ID is null");
            return null;
        }
        return categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun category avec l'ID = " + id + " n'a été trouvé dans la BDD",
                        ErrorCodes.CATEGORY_NOT_FOUND));
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Category ID is null");
            return;
        }
        categoryRepository.deleteById(id);
    }
}
