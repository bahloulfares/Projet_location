package com.projet.location.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;  // Nom de l'utilisateur

    private String prenom;  // Prénom de l'utilisateur

    private String email;  // Adresse email de l'utilisateur

    private String password;  // Mot de passe de l'utilisateur

    private String role;

    @OneToMany(mappedBy = "manager")
    private List<Depot> depots;  // Liste des dépôts gérés par l'utilisateur

    // Constructeurs, getters et setters

    public User() {}

    public User(String nom, String prenom, String email, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
    }

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Depot> getDepots() {
        return depots;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setDepots(List<Depot> depots) {
        this.depots = depots;
    }
}
