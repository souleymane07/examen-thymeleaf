package com.groupeisi.examen_thhymeleaf.mapper;

import com.groupeisi.examen_thhymeleaf.dto.SectorDto;
import com.groupeisi.examen_thhymeleaf.entity.SectorEntity;


import java.util.stream.Collectors;

public class SectorMapper {

    public static SectorDto toDto(SectorEntity entity) {
        if (entity == null) return null;
        SectorDto dto = new SectorDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        if (entity.getClasses() != null) {
            dto.setClasses(entity.getClasses().stream()
                    .map(ClasseMapper::toDto)
                    .collect(Collectors.toList()));
        }
        return dto;
    }

    public static SectorEntity toEntity(SectorDto dto) {
        if (dto == null) return null;
        SectorEntity entity = new SectorEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }
}