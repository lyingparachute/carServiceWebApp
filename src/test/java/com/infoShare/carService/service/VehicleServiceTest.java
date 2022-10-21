package com.infoShare.carService.service;

import com.infoShare.carService.dto.CreateVehicleDto;
import com.infoShare.carService.dto.VehicleDto;
import com.infoShare.carService.enums.Color;
import com.infoShare.carService.model.Vehicle;
import com.infoShare.carService.repository.VehicleRepository;
import com.infoShare.carService.repository.util.InitData;
import org.assertj.core.groups.Tuple;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class VehicleServiceTest {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private InitData initData;

    @BeforeEach
    void setUp() {
        initData.cleanUp();
    }

    @Test
    void shouldSaveVehicleAndSetFixedToFalse() {
        //given
        CreateVehicleDto vehicle = createDummyVehicle();

        //when
        CreateVehicleDto savedVehicle = vehicleService.saveVehicle(vehicle);

        //then
        assertThat(vehicleRepository.findVehicleByRegistrationNumber(savedVehicle.getRegistrationNumber())).isNotNull();
        Vehicle actual = vehicleRepository.findVehicleByRegistrationNumber(vehicle.getRegistrationNumber());
        assertThat(actual.getId()).isNotNull();
        assertThat(actual.isFixed()).isFalse();
        assertThat(actual.getRegistrationNumber()).isEqualTo(vehicle.getRegistrationNumber());
        assertThat(actual.getName()).isEqualTo(vehicle.getName());
        assertThat(actual.getColor()).isEqualTo(vehicle.getColor());
        assertThat(actual.getProductionDate()).isEqualTo(vehicle.getProductionDate());
    }

    @NotNull
    private static CreateVehicleDto createDummyVehicle() {
        CreateVehicleDto vehicle = new CreateVehicleDto();
        vehicle.setName("Audi");
        vehicle.setRegistrationNumber("GD 123");
        vehicle.setColor(Color.WHITE);
        vehicle.setProductionDate(2021);
        return vehicle;
    }

    @Test
    void shouldFixVehicleGivenVehiclesId() {
        //given
        Vehicle vehicle = initData.createAudi();
        //when
        VehicleDto actual = vehicleService.fixVehicleById(vehicle.getId());
        //then
        assertThat(actual).isNotNull();
        assertThat(actual.isFixed()).isTrue();
    }

    @Test
    void shouldReturnAllVehicles() {
        //given
        Vehicle vehicle1 = initData.createAudi();
        Vehicle vehicle2 = initData.createMercedes();
        //when
        List<VehicleDto> actual = vehicleService.getAllVehicles();
        //then
        assertThat(actual).isNotEmpty();
        assertThat(actual).extracting(
                VehicleDto::getId,
                VehicleDto::getName,
                VehicleDto::getColor,
                VehicleDto::getRegistrationNumber,
                VehicleDto::getProductionDate
        ).containsExactlyInAnyOrder(
                Tuple.tuple(vehicle1.getId(), vehicle1.getName(), vehicle1.getColor(), vehicle1.getRegistrationNumber(), vehicle1.getProductionDate()),
                Tuple.tuple(vehicle2.getId(), vehicle2.getName(), vehicle2.getColor(), vehicle2.getRegistrationNumber(), vehicle2.getProductionDate()));
    }

    @Test
    void getVehicleById() {
    }

    @Test
    void findVehicleByName() {
    }

    @Test
    void findByRegistrationNumber() {
    }

    @Test
    void findFixedVehicles() {
    }

    @Test
    void findNotFixedVehicles() {
    }
}