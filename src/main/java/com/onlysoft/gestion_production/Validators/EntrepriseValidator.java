package com.onlysoft.gestion_production.Validators;
import com.onlysoft.gestion_production.dto.CommandeFournisseurDto;
import com.onlysoft.gestion_production.dto.EntrepriseDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
public class EntrepriseValidator {
    public static List<String> validate(EntrepriseDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("Veuillez renseigner le nom de l'entreprise");
            errors.add("Veuillez reseigner la description de l'entreprise");
            errors.add("Veuillez reseigner le code fiscal de l'entreprise");
            errors.add("Veuillez reseigner l'email de l'entreprise");
            errors.add("Veuillez reseigner le numero de telephone de l'entreprise");
            errors.addAll(AdresseValidator.validate(null));
            return errors;
        }

        if (!StringUtils.hasLength(dto.getDesignation())) {
            errors.add("Veuillez renseigner le nom de l'entreprise");
        }
        if (!StringUtils.hasLength(dto.getDescription())) {
            errors.add("Veuillez reseigner la description de l'entreprise");
        }

        return errors;
    }
}
