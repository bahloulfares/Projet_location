package com.projet.location.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Depot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Nom du dépôt

    private String adresse; // Adresse du dépôt

    private String telephone; // Téléphone du dépôt

    private String fax; // Fax du dépôt

    @ManyToOne
    @JoinColumn(name = "manager_id", nullable = false) // Responsable du dépôt
    private User manager;

    @OneToMany(mappedBy = "depot", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Equipment> equipments; // Liste des équipements dans le dépôt
}
