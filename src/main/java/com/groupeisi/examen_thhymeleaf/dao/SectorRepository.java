package com.groupeisi.examen_thhymeleaf.dao;

import com.groupeisi.examen_thhymeleaf.entity.SectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectorRepository extends JpaRepository<SectorEntity, Long> {
}