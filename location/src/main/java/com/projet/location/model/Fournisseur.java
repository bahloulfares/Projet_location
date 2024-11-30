package com.projet.location.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom; // Nom du fournisseur

    private String prenom; // Prénom du fournisseur

    private String adresse; // Adresse du fournisseur

    private String telephone; // Téléphone du fournisseur

    private String fax; // Fax du fournisseur

    private String email; // Adresse électronique du fournisseur

    @OneToMany(mappedBy = "fournisseur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Equipment> equipments; // Liste des équipements fournis par ce fournisseur
}
