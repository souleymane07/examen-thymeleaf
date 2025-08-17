package com.groupeisi.examen_thhymeleaf.controller;

import com.groupeisi.examen_thhymeleaf.dto.ClasseDto;
import com.groupeisi.examen_thhymeleaf.service.ClasseService;
import com.groupeisi.examen_thhymeleaf.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.Optional;

@Controller
public class ClasseController {

    private final ClasseService classeService;
    private final SectorService sectorService;

    @Autowired
    public ClasseController(ClasseService classeService, SectorService sectorService) {
        this.classeService = classeService;
        this.sectorService = sectorService;
    }

    // Affiche la liste de toutes les classes
    @GetMapping("/classes")
    public String listClasses(Model model) {
        model.addAttribute("classes", classeService.getAllClasses());
        return "classe/list";
    }

    // Affiche les détails d'une classe spécifique
    @GetMapping("/classes/{id}")
    public String showClasseDetails(@PathVariable("id") Long id, Model model) {
        Optional<ClasseDto> classeDto = classeService.getClasseById(id);
        classeDto.ifPresent(dto -> model.addAttribute("classe", dto));
        return "classe/details";
    }

    // Affiche le formulaire d'ajout d'une nouvelle classe
    @GetMapping("/classes/new")
    public String showClasseForm(Model model) {
        model.addAttribute("classe", new ClasseDto());
        model.addAttribute("sectors", sectorService.getAllSectors());
        return "classe/form";
    }
    // Gère la soumission du formulaire pour sauvegarder une classe avec validation
    @PostMapping("/classes/save")
    public String saveClasse(@Valid @ModelAttribute("classe") ClasseDto classeDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("sectors", sectorService.getAllSectors());
            return "classe/form";
        }
        classeService.saveClasse(classeDto);
        return "redirect:/classes";
    }

    // Affiche le formulaire de modification pour une classe existante
    @GetMapping("/classes/edit/{id}")
    public String showEditClasseForm(@PathVariable("id") Long id, Model model) {
        Optional<ClasseDto> classeDto = classeService.getClasseById(id);
        if (classeDto.isPresent()) {
            model.addAttribute("classe", classeDto.get());
            model.addAttribute("sectors", sectorService.getAllSectors());
            return "classe/form";
        } else {
            return "redirect:/classes";
        }
    }

    // Gère la suppression d'une classe
    @GetMapping("/classes/delete/{id}")
    public String deleteClasse(@PathVariable("id") Long id) {
        classeService.deleteClasse(id);
        return "redirect:/classes";
    }
}