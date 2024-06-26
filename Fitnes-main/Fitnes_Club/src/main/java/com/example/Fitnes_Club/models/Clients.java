package com.example.Fitnes_Club.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "clients", schema = "public", catalog = "An_URS")
public class Clients {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long Id;
    @Column(name = "start_date")
    private int start_date;
    @Column(name = "end_date")
    private int end_date;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="coach_id")
    private Agent coach;
}
