package com.infoShare.carService.controllers;

import com.infoShare.carService.service.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("vehicles")
public class VehiclesController {
    private final VehicleService vehicleService;

    public VehiclesController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("")
    public String getAllVehicles(){
        return "vehicles-view";
    }

    @GetMapping("fixed")
    public String getAllFixedVehicles(){
        return "vehicles-fixed-view";
    }

}
