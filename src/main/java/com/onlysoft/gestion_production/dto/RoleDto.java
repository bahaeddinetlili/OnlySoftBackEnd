package com.onlysoft.gestion_production.dto;

import com.onlysoft.gestion_production.entities.Role;
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
public class RoleDto {

    private Integer id;

    private String nom;

    public static RoleDto fromEntity(Role role) {
        if (role == null) {
            return null;
        }
        return RoleDto.builder()
                .id(role.getId())
                .nom(role.getNom())
                .build();
    }

    public static Role toEntity(RoleDto roleDto) {
        if (roleDto == null) {
            return null;
        }
        return Role.builder()
                .id(roleDto.getId())
                .nom(roleDto.getNom())
                .build();
    }
}
