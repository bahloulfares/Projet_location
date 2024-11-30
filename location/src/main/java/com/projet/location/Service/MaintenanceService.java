package com.projet.location.Service;

import com.projet.location.Repository.MaintenanceRepository;
import com.projet.location.Repository.EquipmentRepository;
import com.projet.location.model.Maintenance;
import com.projet.location.model.StatusMaintenance;
import com.projet.location.model.Equipment;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceService {

    private final MaintenanceRepository maintenanceRepository;
    private final EquipmentRepository equipmentRepository;

    @Autowired
    public MaintenanceService(MaintenanceRepository maintenanceRepository, EquipmentRepository equipmentRepository) {
        this.maintenanceRepository = maintenanceRepository;
        this.equipmentRepository = equipmentRepository;
    }

    // Method to request maintenance with equipment
    public Maintenance demanderMaintenance(Maintenance maintenance) {
        // Optional: Set equipment if needed
        if (maintenance.getEquipment() != null) {
            Optional<Equipment> equipmentOptional = equipmentRepository.findById(maintenance.getEquipment().getId());
            if (equipmentOptional.isEmpty()) {
                throw new RuntimeException("Equipment with ID " + maintenance.getEquipment().getId() + " not found.");
            }
            maintenance.setEquipment(equipmentOptional.get());
        }
        maintenance.setDescription(maintenance.getDescription());
        maintenance.setDateDemande(LocalDate.now());
        maintenance.setStatus(StatusMaintenance.PENDING);

        return maintenanceRepository.save(maintenance);
    }

    public Maintenance updateMaintenanceStatus(Long id, StatusMaintenance newStatus) {
        Maintenance maintenance = maintenanceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Maintenance request with ID " + id + " not found"));

        // Validation de la transition d'état
        if (!isValidTransition(maintenance.getStatus(), newStatus)) {
            throw new IllegalArgumentException("Invalid status transition from " + maintenance.getStatus() + " to " + newStatus);
        }

        maintenance.setStatus(newStatus);
        return maintenanceRepository.save(maintenance);
    }


    private boolean isValidTransition(StatusMaintenance currentStatus, StatusMaintenance newStatus) {
        // Logique des transitions valides
        switch (currentStatus) {
            case PENDING:
                return newStatus == StatusMaintenance.IN_PROGRESS || newStatus == StatusMaintenance.COMPLETED;
            case IN_PROGRESS:
                return newStatus == StatusMaintenance.COMPLETED;
            default:
                return false;
        }
    }

    // List all maintenance requests
    public List<Maintenance> listerMaintenances() {
        return maintenanceRepository.findAll();
    }
}
