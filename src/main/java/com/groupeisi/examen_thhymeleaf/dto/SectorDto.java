package com.groupeisi.examen_thhymeleaf.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

@Data
public class SectorDto {
    private Long id;
    @NotBlank(message = "Le nom ne peut pas être vide")
    private String name;
    private List<ClasseDto> classes;
}