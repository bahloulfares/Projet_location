package com.projet.location.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;  // Nom du client
    private String prenom;  // Prénom du client
    private String adresse;  // Adresse du client
    private String telephone;  // Téléphone du client
    private String fax;  // Fax du client
    private String email;  // E-mail du client
    private String matriculeFiscale;  // Matricule fiscal du client

    @OneToMany(mappedBy = "client")
    private List<LocationContract> contracts;  // Contrats de location associés au client

    public Client() {}


}
