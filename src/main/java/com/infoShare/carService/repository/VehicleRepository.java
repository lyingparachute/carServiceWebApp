package com.infoShare.carService.repository;

import com.infoShare.carService.model.Vehicle;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface VehicleRepository extends JpaRepository<Vehicle, UUID> {
    List<Vehicle> findByName(String name);
    List<Vehicle> findByName(String name, Sort sort);
    @Query("select v from Vehicle v where v.isFixed = ?1")
    List<Vehicle> findByFixed(boolean isFixed, Sort sort);
}
