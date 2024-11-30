package com.projet.location.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;  // Nom du matériel

    private String state;  // L'état du matériel (Neuf, Occasion, Usé)

    private String category;  // Catégorie du matériel (par exemple : "Matériel de chantier", "Matériel informatique")

    private Double capacity;  // Capacité du matériel (par exemple : capacité de charge ou capacité de travail)

    private Double rentalPricePerDay;  // Prix de location journalier du matériel

    @ManyToOne
    @JoinColumn(name = "depot_id", nullable = false)// Relation avec Depot
    @JsonIgnore
    private Depot depot;

    @ManyToOne
    @JoinColumn(name = "fournisseur_id", nullable = false)  // Relation avec Fournisseur (fournisseur)
    @JsonIgnore
    private Fournisseur fournisseur;  // Fournisseur de l'équipement

    // Constructeurs
    public Equipment() {}

    public Equipment(String name, String state, String category, Double capacity, Double rentalPricePerDay, Depot depot, Fournisseur fournisseur) {
        this.name = name;
        this.state = state;
        this.category = category;
        this.capacity = capacity;
        this.rentalPricePerDay = rentalPricePerDay;
        this.depot = depot;
        this.fournisseur = fournisseur;  // Lien vers le fournisseur
    }

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public Double getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    public void setRentalPricePerDay(Double rentalPricePerDay) {
        this.rentalPricePerDay = rentalPricePerDay;
    }

    public Depot getDepot() {
        return depot;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }
}
