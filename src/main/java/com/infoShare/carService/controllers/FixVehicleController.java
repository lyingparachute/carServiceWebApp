package com.infoShare.carService.controllers;

import com.infoShare.carService.dto.VehicleDto;
import com.infoShare.carService.service.VehicleService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Controller
@RequestMapping("vehicle")
public class FixVehicleController {
    private final VehicleService vehicleService;

    public FixVehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("fixed")
    public String fixedVehicles(Model model) {

        return "fix-vehicle";
    }

    @GetMapping("fix/{id}")
    public String fixVehicleView(@PathVariable (value = "id") UUID id, Model model) {
        VehicleDto vehicleDto = vehicleService.fixVehicleById(id);
        if (vehicleDto == null) {
            return "not-found";
        }
        model.addAttribute("vehicle", vehicleDto);
        return "fixed-vehicle";
    }

    @GetMapping("fix")
    public String getVehicleByRegistrationNumber(Model model, @Param("registrationNumber") String registrationNumber) {
        model.addAttribute("vehicle", vehicleService.findByRegistrationNumber(registrationNumber));
        return "fix-vehicle";
    }
}
