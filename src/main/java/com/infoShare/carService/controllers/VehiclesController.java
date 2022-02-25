package com.infoShare.carService.controllers;

import com.infoShare.carService.service.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehiclesController {
    private final VehicleService vehicleService;

    public VehiclesController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("vehicles")
    public String addNewVehicleForm(){
        return "vehicles-view";
    }

}
