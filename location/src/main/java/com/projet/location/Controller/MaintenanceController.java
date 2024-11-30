package com.projet.location.Controller;

import com.projet.location.Service.MaintenanceService;
import com.projet.location.model.Maintenance;
import com.projet.location.model.StatusMaintenance;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/maintenances")
public class MaintenanceController {

    private final MaintenanceService maintenanceService;

    public MaintenanceController(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    @PostMapping
    public Maintenance demanderMaintenance(@RequestBody Maintenance maintenance) {
        if (maintenance.getDescription() == null || maintenance.getDescription().trim().isEmpty()) {
            throw new IllegalArgumentException("La description ne peut pas être vide !");
        }

        // You can now pass the entire Maintenance object which may include equipment
        return maintenanceService.demanderMaintenance(maintenance);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Maintenance> updateMaintenanceStatus(
            @PathVariable Long id,
            @RequestParam StatusMaintenance status) {
        try {
            Maintenance updatedMaintenance = maintenanceService.updateMaintenanceStatus(id, status);
            return ResponseEntity.ok(updatedMaintenance);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(null);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping
    public List<Maintenance> listerMaintenances() {
        return maintenanceService.listerMaintenances();
    }
}
