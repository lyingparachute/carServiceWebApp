package com.infoShare.carService.controllers;

import com.infoShare.carService.service.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("vehicle")
public class FixVehicleController {
    private final VehicleService vehicleService;

    public FixVehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("fixed")
    public String fixedVehicles() {
        return "fix-vehicle";
    }

    @GetMapping("fix")
    public String addVehicleToFix() {
        return "fix-vehicle";
    }
}
