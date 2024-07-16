package com.onlysoft.gestion_production.dto;

import com.onlysoft.gestion_production.entities.LigneVente;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class LigneVenteDto {

    private Integer id;

    private VentesDto vente;

    private BigDecimal quantite;

    public static LigneVenteDto fromEntity(LigneVente ligneVente) {
        if (ligneVente == null) {
            return null;
        }
        return LigneVenteDto.builder()
                .id(ligneVente.getId())
                .vente(VentesDto.fromEntity(ligneVente.getVente()))
                .quantite(ligneVente.getQuantite())
                .build();
    }

    public static LigneVente toEntity(LigneVenteDto ligneVenteDto) {
        if (ligneVenteDto == null) {
            return null;
        }
        return LigneVente.builder()
                .id(ligneVenteDto.getId())
                .vente(VentesDto.toEntity(ligneVenteDto.getVente()))
                .quantite(ligneVenteDto.getQuantite())
                .build();
    }
}
