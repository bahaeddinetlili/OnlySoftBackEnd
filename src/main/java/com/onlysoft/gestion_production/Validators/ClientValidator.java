package com.onlysoft.gestion_production.Validators;

import com.onlysoft.gestion_production.dto.ClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {

    public static List<String> validate(ClientDto clientDto) {
        List<String> errors = new ArrayList<>();

        if (clientDto == null) {
            errors.add("ClientDto est null, Veuillez renseigner le nom du client, le prenom du client, l'email du client, le numero de telephone du client, ainsi que l'adresse.");
            return errors;
        }

        if (!StringUtils.hasLength(clientDto.getNom())) {
            errors.add("Veuillez renseigner le nom du client");
        }
        if (!StringUtils.hasLength(clientDto.getPrenom())) {
            errors.add("Veuillez renseigner le prenom du client");
        }
        if (!StringUtils.hasLength(clientDto.getEmail())) {
            errors.add("Veuillez renseigner le Mail du client");
        }
        if (!StringUtils.hasLength(clientDto.getNumTel())) {
            errors.add("Veuillez renseigner le numero de telephone du client");
        }
        errors.addAll(AdresseValidator.validate(clientDto.getAdresse()));
        return errors;
    }
}
