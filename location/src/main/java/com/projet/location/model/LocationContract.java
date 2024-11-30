package com.projet.location.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class LocationContract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contractNumber;  // Numéro du contrat
    private Date contractDate;  // Date du contrat
    private double totalAmount;  // Montant total de la location

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;  // Client associé au contrat

    @ManyToOne
    @JoinColumn(name = "depot_id", nullable = false)
    private Depot depot;  // Dépôt où le matériel a été loué

    @ManyToMany
    @JoinTable(
            name = "contract_equipment",
            joinColumns = @JoinColumn(name = "contract_id"),
            inverseJoinColumns = @JoinColumn(name = "equipment_id")
    )
    private List<Equipment> equipments;  // Liste des matériels loués

    public LocationContract() {}

    public LocationContract(String contractNumber, Date contractDate, double totalAmount, Client client, Depot depot) {
        this.contractNumber = contractNumber;
        this.contractDate = contractDate;
        this.totalAmount = totalAmount;
        this.client = client;
        this.depot = depot;
    }

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Depot getDepot() {
        return depot;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }
}
