package com.infoShare.carService.service;

import com.infoShare.carService.dto.CreateVehicleDto;
import com.infoShare.carService.dto.VehicleDto;
import com.infoShare.carService.model.Vehicle;
import com.infoShare.carService.repository.VehicleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
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
    public CreateVehicleDto saveVehicle(CreateVehicleDto createVehicleDto) {
        Vehicle vehicle = modelMapper.map(createVehicleDto, Vehicle.class);
        vehicle.setFixed(false);
        Vehicle persistedEntity = vehicleRepository.save(vehicle);
        return modelMapper.map(persistedEntity, CreateVehicleDto.class);
    }

    public VehicleDto fixVehicleById(UUID id) {
        vehicleRepository.updateVehicle(true , id);
        return getVehicleById(id);
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

    @Override
    public List<VehicleDto> findFixedVehicles() {
        return vehicleRepository.findByFixed(Sort.by(Sort.Direction.ASC, "productionDate"))
                .stream().map(vehicle -> modelMapper.map(vehicle, VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> findNotFixedVehicles() {
        return vehicleRepository.findNotFixed(Sort.by(Sort.Direction.ASC, "productionDate"))
                .stream().map(vehicle -> modelMapper.map(vehicle, VehicleDto.class))
                .collect(Collectors.toList());
    }
}
