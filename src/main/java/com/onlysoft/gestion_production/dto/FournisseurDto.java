package com.onlysoft.gestion_production.dto;

import com.onlysoft.gestion_production.entities.Fournisseur;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class FournisseurDto {

    private Integer id;

    private String nom;

    private String prenom;

    private String email;

    private String mail;

    private String numTel;

    private List<CommandeFournisseurDto> commandeFournisseurs;

    public static FournisseurDto fromEntity(Fournisseur fournisseur) {
        if (fournisseur == null) {
            return null;
        }
        return FournisseurDto.builder()
                .id(fournisseur.getId())
                .nom(fournisseur.getNom())
                .prenom(fournisseur.getPrenom())
                .email(fournisseur.getEmail())
                .email(fournisseur.getEmail())
                .numTel(fournisseur.getNumTel())
                .commandeFournisseurs(fournisseur.getCommandeFournisseurs().stream()
                        .map(CommandeFournisseurDto::fromEntity)
                        .collect(Collectors.toList()))
                .build();
    }

    public static Fournisseur toEntity(FournisseurDto fournisseurDto) {
        if (fournisseurDto == null) {
            return null;
        }
        return Fournisseur.builder()
                .id(fournisseurDto.getId())
                .nom(fournisseurDto.getNom())
                .email(fournisseurDto.getEmail())
                .prenom(fournisseurDto.getPrenom())
                .email(fournisseurDto.getEmail())
                .numTel(fournisseurDto.getNumTel())
                .build();
    }
}
