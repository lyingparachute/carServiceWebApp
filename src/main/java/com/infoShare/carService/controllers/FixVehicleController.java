package com.infoShare.carService.controllers;

import com.infoShare.carService.dto.VehicleDto;
import com.infoShare.carService.service.VehicleService;
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
    public String fixVehicleView(@PathVariable UUID id, Model model) {
        VehicleDto vehicleDto = vehicleService.fixVehicleById(id);
        if (vehicleDto == null) {
            return "not-found";
        }
        model.addAttribute("vehicle", vehicleDto);
        return "fixed-vehicle";
    }

    @GetMapping("fix")
    public String addVehicleToFix(Model model) {
        //TODO
        //Add view with input of registration plate to fix a car - change isFixed to true.
        return "fix-vehicle";
    }
}
