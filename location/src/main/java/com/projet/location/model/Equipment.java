package com.projet.location.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Nom du matériel

    private String state; // L'état du matériel (Neuf, Occasion, Usé)

    private String category; // Catégorie du matériel (par exemple : "Matériel de chantier", "Matériel informatique")

    private Double capacity; // Capacité du matériel (ex. : capacité de charge ou de travail)

    private Double rentalPricePerDay; // Prix de location journalier du matériel

    @ManyToOne
    @JoinColumn(name = "depot_id", nullable = false) // Relation avec Depot
    @JsonIgnore
    private Depot depot;

    @ManyToOne
    @JoinColumn(name = "fournisseur_id", nullable = false) // Relation avec Fournisseur
    @JsonIgnore
    private Fournisseur fournisseur; // Fournisseur de l'équipement
}
