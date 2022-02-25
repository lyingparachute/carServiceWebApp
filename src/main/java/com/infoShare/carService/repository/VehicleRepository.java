package com.infoShare.carService.repository;

import com.infoShare.carService.model.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VehicleRepository extends JpaRepository<VehicleEntity, UUID> {
}
