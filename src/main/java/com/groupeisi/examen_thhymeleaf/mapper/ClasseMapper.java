package com.groupeisi.examen_thhymeleaf.mapper;

import com.groupeisi.examen_thhymeleaf.dto.ClasseDto;
import com.groupeisi.examen_thhymeleaf.entity.ClasseEntity;
import com.groupeisi.examen_thhymeleaf.entity.SectorEntity; // Import nécessaire

public class ClasseMapper {

    public static ClasseDto toDto(ClasseEntity entity) {
        if (entity == null) {
            return null;
        }
        ClasseDto dto = new ClasseDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        if (entity.getSector() != null) {
            dto.setSectorId(entity.getSector().getId());
            dto.setSectorName(entity.getSector().getName());
        }
        return dto;
    }

    public static ClasseEntity toEntity(ClasseDto dto) {
        if (dto == null) {
            return null;
        }
        ClasseEntity entity = new ClasseEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());

        // Laisser le secteur être géré par le service
        if (dto.getSectorId() != null) {
            SectorEntity sector = new SectorEntity();
            sector.setId(dto.getSectorId());
            entity.setSector(sector);
        }
        return entity;
    }
}