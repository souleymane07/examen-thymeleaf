package com.groupeisi.examen_thhymeleaf.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
public class ClasseDto {
    private Long id;

    @NotBlank(message = "Le nom ne peut pas être vide")
    @Size(min = 3, max = 50, message = "Le nom doit contenir entre 3 et 50 caractères")
    private String name;

    private String description;

    @NotNull(message = "Le secteur ne peut pas être vide")
    private Long sectorId;
    private String sectorName;
}