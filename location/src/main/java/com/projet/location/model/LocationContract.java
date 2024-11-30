package com.projet.location.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationContract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contractNumber; // Numéro du contrat
    private Date contractDate; // Date du contrat
    private double totalAmount; // Montant total de la location

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client; // Client associé au contrat

    @ManyToOne
    @JoinColumn(name = "depot_id", nullable = false)
    private Depot depot; // Dépôt où le matériel a été loué

    @ManyToMany
    @JoinTable(
            name = "contract_equipment",
            joinColumns = @JoinColumn(name = "contract_id"),
            inverseJoinColumns = @JoinColumn(name = "equipment_id")
    )
    private List<Equipment> equipments; // Liste des matériels loués
}
