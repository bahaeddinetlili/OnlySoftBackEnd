package com.onlysoft.gestion_production.dto;

import com.onlysoft.gestion_production.entities.MvtStk;
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
public class MvtStkDto {

    @Id
    @GeneratedValue
    private Integer id;

    private Number Quantite;

    public static MvtStkDto fromEntity(MvtStk mvtStk) {
        if (mvtStk == null) {
            return null;
        }
        return MvtStkDto.builder()
                .id(mvtStk.getId())
                .Quantite(mvtStk.getQuantite())
                .build();
    }

    public static MvtStk toEntity(MvtStkDto mvtStkDto) {
        if (mvtStkDto == null) {
            return null;
        }
        return MvtStk.builder()
                .id(mvtStkDto.getId())
                .Quantite(mvtStkDto.getQuantite())
                .build();
    }
}
