package com.infoShare.carService.service;

import com.infoShare.carService.model.VehicleEntity;
import com.infoShare.carService.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Transactional
    public VehicleEntity saveVehicle(String name, String registrationNumber){
        VehicleEntity vehicleEntity = new VehicleEntity(name, registrationNumber);
        return vehicleRepository.save(vehicleEntity);
    }

}
