package com.groupeisi.examen_thhymeleaf.controller;

import com.groupeisi.examen_thhymeleaf.dto.SectorDto;
import com.groupeisi.examen_thhymeleaf.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.Optional;
@Controller
public class SectorController {

    private final SectorService sectorService;

    @Autowired
    public SectorController(SectorService sectorService) {
        this.sectorService = sectorService;
    }

    // Affiche la liste de tous les secteurs
    @GetMapping("/sectors")
    public String listSectors(Model model) {
        model.addAttribute("sectors", sectorService.getAllSectors());
        return "sector/list";
    }

    // Affiche les détails d'un secteur spécifique
    @GetMapping("/sectors/{id}")
    public String showSectorDetails(@PathVariable("id") Long id, Model model) {
        Optional<SectorDto> sectorDto = sectorService.getSectorById(id);
        sectorDto.ifPresent(dto -> model.addAttribute("sector", dto));
        return "sector/details";
    }

    // Affiche le formulaire d'ajout d'un nouveau secteur
    @GetMapping("/sectors/new")
    public String showSectorForm(Model model) {
        model.addAttribute("sector", new SectorDto());
        return "sector/form";
    }


    @PostMapping("/sectors/save")
    public String saveSector(@Valid @ModelAttribute("sector") SectorDto sectorDto, BindingResult result) {
        if (result.hasErrors()) {
            return "sector/form";
        }
        sectorService.saveSector(sectorDto);
        return "redirect:/sectors";
    }

    // Gère l'affichage du formulaire de modification
    @GetMapping("/sectors/edit/{id}")
    public String showEditSectorForm(@PathVariable("id") Long id, Model model) {
        Optional<SectorDto> sectorDto = sectorService.getSectorById(id);
        if (sectorDto.isPresent()) {
            model.addAttribute("sector", sectorDto.get());
            return "sector/form";
        } else {
            return "redirect:/sectors";
        }
    }

    // 🆕 Gère la suppression d'un secteur
    @GetMapping("/sectors/delete/{id}")
    public String deleteSector(@PathVariable("id") Long id) {
        sectorService.deleteSector(id);
        return "redirect:/sectors";
    }
}