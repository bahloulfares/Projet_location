package com.projet.location.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;

    private LocalDate dateDemande;

    @Enumerated(EnumType.STRING)
    private StatusMaintenance status;

    @ManyToOne
    @JoinColumn(name = "equipment_id", nullable = false) // Clé étrangère dans la table Maintenance
    private Equipment equipment;
}
