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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom; // Nom de l'utilisateur

    private String prenom; // Prénom de l'utilisateur

    private String email; // Adresse email de l'utilisateur

    private String password; // Mot de passe de l'utilisateur

    private String role; // Rôle de l'utilisateur

    @OneToMany(mappedBy = "manager")
    private List<Depot> depots; // Liste des dépôts gérés par l'utilisateur
}
