package com.onlysoft.gestion_production.dto;

import com.onlysoft.gestion_production.entities.CommandeFournisseur;
import com.onlysoft.gestion_production.entities.EtatCommande;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CommandeFournisseurDto {

    private Integer id;

    private String code;

    private Instant dateCommande;


    private EtatCommande etatCommande;

    private FournisseurDto fournisseur;

    private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs;

    public static CommandeFournisseurDto fromEntity(CommandeFournisseur commandeFournisseur) {
        if (commandeFournisseur == null) {
            return null;
        }
        return CommandeFournisseurDto.builder()
                .id(commandeFournisseur.getId())
                .code(commandeFournisseur.getCode())
                .etatCommande(commandeFournisseur.getEtatCommande())
                .dateCommande(commandeFournisseur.getDateCommande())
                .fournisseur(FournisseurDto.fromEntity(commandeFournisseur.getFournisseur()))
                .ligneCommandeFournisseurs(commandeFournisseur.getLigneCommandeFournisseurs().stream()
                        .map(LigneCommandeFournisseurDto::fromEntity)
                        .collect(Collectors.toList()))
                .build();
    }

    public static CommandeFournisseur toEntity(CommandeFournisseurDto commandeFournisseurDto) {
        if (commandeFournisseurDto == null) {
            return null;
        }
        return CommandeFournisseur.builder()
                .id(commandeFournisseurDto.getId())
                .code(commandeFournisseurDto.getCode())
                .etatCommande(commandeFournisseurDto.getEtatCommande())
                .dateCommande(commandeFournisseurDto.getDateCommande())
                .fournisseur(FournisseurDto.toEntity(commandeFournisseurDto.getFournisseur()))
                .ligneCommandeFournisseurs(commandeFournisseurDto.getLigneCommandeFournisseurs().stream()
                        .map(LigneCommandeFournisseurDto::toEntity)
                        .collect(Collectors.toList()))
                .build();
    }
}
