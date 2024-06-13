package com.example.Fitnes_Club.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Building", schema = "public", catalog = "An_URS")
public class Building {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long buildingId;

    @Column(name = "quality")
    private String quality;

    @Column(name = "size")
    private String size;

    @Column(name = "numFloors")
    private int numFloors;

    @Column(name = "numEntrances")
    private int numEntrances;
}
