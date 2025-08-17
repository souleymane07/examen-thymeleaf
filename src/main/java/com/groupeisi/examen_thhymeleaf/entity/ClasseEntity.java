package com.groupeisi.examen_thhymeleaf.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
@Table(name = "classes")
public class ClasseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sector_id", nullable = false)
    private SectorEntity sector;
}