package com.onlysoft.gestion_production.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.onlysoft.gestion_production.entities.Adresse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class AdresseDto {

    private Integer id;

    private String adresse;

    private String ville;

    private String codePostale;

    private String pays;

    @JsonIgnore
    private ClientDto client;

    public static AdresseDto fromEntity(Adresse adresse) {
        if (adresse == null) {
            return null;
        }
        return AdresseDto.builder()
                .id(adresse.getId())
                .adresse(adresse.getAdresse())
                .ville(adresse.getVille())
                .codePostale(adresse.getCodePostale())
                .pays(adresse.getPays())
                .client(ClientDto.fromEntity(adresse.getClient()))
                .build();
    }

    public static Adresse toEntity(AdresseDto adresseDto) {
        if (adresseDto == null) {
            return null;
        }
        return Adresse.builder()
                .id(adresseDto.getId())
                .adresse(adresseDto.getAdresse())
                .ville(adresseDto.getVille())
                .codePostale(adresseDto.getCodePostale())
                .pays(adresseDto.getPays())
                .client(ClientDto.toEntity(adresseDto.getClient()))
                .build();
    }
}
