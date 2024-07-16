package com.onlysoft.gestion_production.dto;

import com.onlysoft.gestion_production.entities.Entreprise;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class EntrepriseDto {

    private Integer id;

    private String designation;

    private String nom;

    private String description;

    // Add additional fields if needed

    public static EntrepriseDto fromEntity(Entreprise entreprise) {
        if (entreprise == null) {
            return null;
        }
        return EntrepriseDto.builder()
                .id(entreprise.getId())
                .nom(entreprise.getNom())
                .description(entreprise.getDescription())
                .designation(entreprise.getDesignation())
                // Map other fields as needed
                .build();
    }

    public static Entreprise toEntity(EntrepriseDto entrepriseDto) {
        if (entrepriseDto == null) {
            return null;
        }
        return Entreprise.builder()
                .id(entrepriseDto.getId())
                .nom(entrepriseDto.getNom())
                .description(entrepriseDto.getDescription())
                .Designation(entrepriseDto.getDesignation())
                // Map other fields as needed
                .build();
    }
}
