package com.onlysoft.gestion_production.controllers;

import com.onlysoft.gestion_production.dto.CommandeClientDto;
import com.onlysoft.gestion_production.services.CommandeClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/commandeclient")
@CrossOrigin(origins = "http://localhost:4200")
public class CommandeClientController {
    private final CommandeClientService commandeClientService;

    @Autowired
    public CommandeClientController(CommandeClientService commandeClientService) {
        this.commandeClientService = commandeClientService;
    }


    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<CommandeClientDto> save(@RequestBody CommandeClientDto dto) {
        // Appeler le service pour sauvegarder la commande client
        CommandeClientDto savedDto = commandeClientService.save(dto);
        // Retourner la réponse avec le statut 201 (CREATED) et l'objet sauvegardé
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDto);
    }
}
