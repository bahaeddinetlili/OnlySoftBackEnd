package com.onlysoft.gestion_production.dto;

import com.onlysoft.gestion_production.entities.Ventes;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class VentesDto {

    private Integer id;

    private String code;

    public static VentesDto fromEntity(Ventes vente) {
        if (vente == null) {
            return null;
        }
        return VentesDto.builder()
                .id(vente.getId())
                .code(vente.getCode())
                .build();
    }

    public static Ventes toEntity(VentesDto venteDto) {
        if (venteDto == null) {
            return null;
        }
        return Ventes.builder()
                .id(venteDto.getId())
                .code(venteDto.getCode())
                .build();
    }
}
