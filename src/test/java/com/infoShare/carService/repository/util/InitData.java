package com.infoShare.carService.repository.util;

import com.infoShare.carService.enums.Color;
import com.infoShare.carService.model.Vehicle;
import com.infoShare.carService.repository.VehicleRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class InitData {
    private final VehicleRepository vehicleRepository;

    public InitData(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Transactional
    public void cleanUp () {
        vehicleRepository.deleteAll();
    }

    public Vehicle createAudi() {
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Audi");
        vehicle.setRegistrationNumber("GD 123");
        vehicle.setColor(Color.WHITE);
        vehicle.setProductionDate(2021);
        vehicleRepository.save(vehicle);
        return vehicle;
    }

    public Vehicle createMercedes() {
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Mercedes");
        vehicle.setRegistrationNumber("WWA 424");
        vehicle.setColor(Color.BLACK);
        vehicle.setProductionDate(2022);
        vehicleRepository.save(vehicle);
        return vehicle;
    }

}
