package com.onlysoft.gestion_production.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.onlysoft.gestion_production.entities.CommandeClient;
import com.onlysoft.gestion_production.entities.EtatCommande;
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
public class CommandeClientDto {

    private Integer id;

    private String code;

    private Instant dateCommande;


    private EtatCommande etatCommande;

    private ClientDto client;

    @JsonIgnore
    private List<LigneCommandeClientDto> ligneCommandeClients;

    public static CommandeClientDto fromEntity(CommandeClient commandeClient) {
        if (commandeClient == null) {
            return null;
        }
        return CommandeClientDto.builder()
                .id(commandeClient.getId())
                .code(commandeClient.getCode())
                .etatCommande(commandeClient.getEtatCommande())
                .dateCommande(commandeClient.getDateCommande())
                .client(ClientDto.fromEntity(commandeClient.getClient()))
                .ligneCommandeClients(
                        commandeClient.getLigneCommandeClients() != null ?
                                commandeClient.getLigneCommandeClients().stream()
                                        .map(LigneCommandeClientDto::fromEntity)
                                        .collect(Collectors.toList()) : null)
                .build();
    }

    public static CommandeClient toEntity(CommandeClientDto commandeClientDto) {
        if (commandeClientDto == null) {
            return null;
        }
        return CommandeClient.builder()
                .id(commandeClientDto.getId())
                //.etatCommande(commandeClientDto.getEtatCommande())
                .code(commandeClientDto.getCode())
                .dateCommande(commandeClientDto.getDateCommande())
                .client(ClientDto.toEntity(commandeClientDto.getClient()))
                .ligneCommandeClients(
                        commandeClientDto.getLigneCommandeClients() != null ?
                                commandeClientDto.getLigneCommandeClients().stream()
                                        .map(LigneCommandeClientDto::toEntity)
                                        .collect(Collectors.toList()) : null)
                .build();
    }

    public boolean isCommandeLivree() {
        return EtatCommande.LIVREE.equals(this.etatCommande);
    }
}
