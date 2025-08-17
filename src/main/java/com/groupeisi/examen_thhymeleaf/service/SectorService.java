package com.groupeisi.examen_thhymeleaf.service;

import com.groupeisi.examen_thhymeleaf.dao.SectorRepository;
import com.groupeisi.examen_thhymeleaf.dto.SectorDto;
import com.groupeisi.examen_thhymeleaf.mapper.SectorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SectorService {

    private final SectorRepository sectorRepository;

    @Autowired
    public SectorService(SectorRepository sectorRepository) {
        this.sectorRepository = sectorRepository;
    }

    public List<SectorDto> getAllSectors() {
        return sectorRepository.findAll().stream()
                .map(SectorMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<SectorDto> getSectorById(Long id) {
        return sectorRepository.findById(id)
                .map(SectorMapper::toDto);
    }

    public SectorDto saveSector(SectorDto sectorDto) {
        return SectorMapper.toDto(sectorRepository.save(SectorMapper.toEntity(sectorDto)));
    }

    public void deleteSector(Long id) {
        sectorRepository.deleteById(id);
    }
}