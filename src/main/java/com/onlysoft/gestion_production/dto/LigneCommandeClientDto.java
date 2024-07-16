package com.onlysoft.gestion_production.dto;

import com.onlysoft.gestion_production.entities.LigneCommandeClient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class LigneCommandeClientDto {

    private Integer id;

    private ArticleDto article;

    private CommandeClientDto commandeClient;

    private Integer quantite;

    private BigDecimal prixUnitaire;

    public static LigneCommandeClientDto fromEntity(LigneCommandeClient ligneCommandeClient) {
        if (ligneCommandeClient == null) {
            return null;
        }
        return LigneCommandeClientDto.builder()
                .id(ligneCommandeClient.getId())
                .article(ArticleDto.fromEntity(ligneCommandeClient.getArticle()))
                .commandeClient(CommandeClientDto.fromEntity(ligneCommandeClient.getCommandeClient()))
                .quantite(ligneCommandeClient.getQuantite())
                .prixUnitaire(ligneCommandeClient.getPrixUnitaire())
                .build();
    }

    public static LigneCommandeClient toEntity(LigneCommandeClientDto ligneCommandeClientDto) {
        if (ligneCommandeClientDto == null) {
            return null;
        }
        return LigneCommandeClient.builder()
                .id(ligneCommandeClientDto.getId())
                .article(ArticleDto.toEntity(ligneCommandeClientDto.getArticle()))
                .commandeClient(CommandeClientDto.toEntity(ligneCommandeClientDto.getCommandeClient()))
                .Quantite(ligneCommandeClientDto.getQuantite())
                .prixUnitaire(ligneCommandeClientDto.getPrixUnitaire())
                .build();
    }
}
