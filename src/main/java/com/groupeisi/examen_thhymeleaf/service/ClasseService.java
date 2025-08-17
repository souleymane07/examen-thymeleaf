package com.groupeisi.examen_thhymeleaf.service;

import com.groupeisi.examen_thhymeleaf.dao.ClasseRepository;
import com.groupeisi.examen_thhymeleaf.dto.ClasseDto;
import com.groupeisi.examen_thhymeleaf.entity.ClasseEntity;
import com.groupeisi.examen_thhymeleaf.mapper.ClasseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClasseService {

    private final ClasseRepository classeRepository;

    @Autowired
    public ClasseService(ClasseRepository classeRepository) {
        this.classeRepository = classeRepository;
    }

    public List<ClasseDto> getAllClasses() {
        return classeRepository.findAll().stream()
                .map(ClasseMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<ClasseDto> getClasseById(Long id) {
        return classeRepository.findById(id)
                .map(ClasseMapper::toDto);
    }

    public ClasseDto saveClasse(ClasseDto classeDto) {
        ClasseEntity classeEntity = ClasseMapper.toEntity(classeDto);
        return ClasseMapper.toDto(classeRepository.save(classeEntity));
    }

    public void deleteClasse(Long id) {
        classeRepository.deleteById(id);
    }
}