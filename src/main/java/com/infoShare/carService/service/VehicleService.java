package com.infoShare.carService.service;

import com.infoShare.carService.dto.CreateVehicleDto;
import com.infoShare.carService.dto.VehicleDto;
import com.infoShare.carService.model.Vehicle;
import com.infoShare.carService.repository.VehicleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class VehicleService implements VehicleServiceInterface {

    private final VehicleRepository vehicleRepository;
    private final ModelMapper modelMapper;

    public VehicleService(VehicleRepository vehicleRepository, ModelMapper modelMapper) {
        this.vehicleRepository = vehicleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public void saveVehicle(CreateVehicleDto createVehicleDto) {
        Vehicle vehicle = new Vehicle(createVehicleDto.getName(), createVehicleDto.getRegistrationNumber());
        vehicleRepository.save(vehicle);
    }

    @Override
    @Transactional
    public List<VehicleDto> getAllVehicles() {
        List<Vehicle> allVehicles = vehicleRepository.findAll();
        return allVehicles.stream()
                .map(vehicle -> modelMapper.map(allVehicles, VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public VehicleDto getVehicleById(UUID id) {
        Optional<Vehicle> vehicleById = vehicleRepository.findById(id);
        return modelMapper.map(vehicleById, VehicleDto.class);
    }

    @Override
    @Transactional
    public List<VehicleDto> findVehicleByName(String name) {
        return vehicleRepository.findByName(name)
                .stream()
                .map(vehicle -> modelMapper.map(vehicle,VehicleDto.class))
                .collect(Collectors.toList());
    }
}
