package com.groupeisi.examen_thhymeleaf.dao;

import com.groupeisi.examen_thhymeleaf.entity.ClasseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasseRepository extends JpaRepository<ClasseEntity, Long> {
}