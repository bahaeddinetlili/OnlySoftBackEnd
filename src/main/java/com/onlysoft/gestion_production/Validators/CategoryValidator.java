package com.onlysoft.gestion_production.Validators;

import com.onlysoft.gestion_production.dto.CategoryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {
    public static List<String> validate(CategoryDto categoryDto) {
        List<String> errors = new ArrayList<>();

        if (categoryDto == null || !StringUtils.hasLength(categoryDto.getCode())) {
            errors.add("Veuillez renseigner le code de la categorie");
        }
        return errors;
    }
}
