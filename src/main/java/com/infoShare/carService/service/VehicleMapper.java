package com.infoShare.carService.service;

import com.infoShare.carService.dto.CreateVehicleDto;
import com.infoShare.carService.dto.VehicleDto;
import com.infoShare.carService.model.Vehicle;

public class VehicleMapper {
    public CreateVehicleDto toDto(Vehicle vehicle) {
        CreateVehicleDto createVehicleDto = new CreateVehicleDto();
        createVehicleDto.setName(vehicle.getName());
        createVehicleDto.setRegistrationNumber(vehicle.getRegistrationNumber());
        createVehicleDto.setFixed(vehicle.isFixed());
        createVehicleDto.setColor(vehicle.getColor());
        createVehicleDto.setProductionDate(vehicle.getProductionDate());
        return createVehicleDto;
    }


    public Vehicle toEntity(CreateVehicleDto createVehicleDto){
        Vehicle vehicle = new Vehicle();
        vehicle.setName(createVehicleDto.getName());
        vehicle.setRegistrationNumber(createVehicleDto.getRegistrationNumber());
        vehicle.setFixed(createVehicleDto.isFixed());
        vehicle.setColor(createVehicleDto.getColor());
        vehicle.setProductionDate(createVehicleDto.getProductionDate());
        return vehicle;
    }

    public VehicleDto toVehicleDto(Vehicle vehicle) {
        VehicleDto vehicleDto = new VehicleDto();
        vehicleDto.setId(vehicle.getId());
        vehicleDto.setName(vehicle.getName());
        vehicleDto.setRegistrationNumber(vehicle.getRegistrationNumber());
        vehicleDto.setFixed(vehicle.isFixed());
        vehicleDto.setColor(vehicle.getColor());
        vehicleDto.setProductionDate(vehicle.getProductionDate());
        return vehicleDto;
    }
}
