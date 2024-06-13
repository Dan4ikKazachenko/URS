package com.example.Fitnes_Club.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "apartment", schema = "public", catalog = "An_URS")
public class Apartment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long apartmentId;

    @Column(name = "apartmentNumber")
    private String apartmentNumber;

    @Column(name = "areaSquareMeters")
    private double areaSquareMeters;

    @Column(name = "price")
    private double price;

    @Column(name = "renovationNeeded")
    private boolean renovationNeeded;

    @ManyToOne
    @JoinColumn(name = "buildingId")
    private Building building;

    // Дополнительные поля, если необходимо

    // Геттеры и сеттеры
}

