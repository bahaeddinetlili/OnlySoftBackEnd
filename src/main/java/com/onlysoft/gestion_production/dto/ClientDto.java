package com.onlysoft.gestion_production.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.onlysoft.gestion_production.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ClientDto {

    private Integer id;

    private String nom;

    private String prenom;

    private AdresseDto adresse;

    private String email;

    private String numTel;

    @JsonIgnore
    private List<CommandeClientDto> commandeClients;

    public static ClientDto fromEntity(Client client) {
        if (client == null) {
            return null;
        }
        return ClientDto.builder()
                .id(client.getId())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .adresse(AdresseDto.fromEntity(client.getAdresse()))
                .email(client.getEmail())
                .numTel(client.getNumTel())
                .build();
    }

    public static Client toEntity(ClientDto clientDto) {
        if (clientDto == null) {
            return null;
        }
        return Client.builder()
                .id(clientDto.getId())
                .nom(clientDto.getNom())
                .prenom(clientDto.getPrenom())
                .adresse(AdresseDto.toEntity(clientDto.getAdresse()))
                .email(clientDto.getEmail())
                .numTel(clientDto.getNumTel())
                .build();
    }
}
