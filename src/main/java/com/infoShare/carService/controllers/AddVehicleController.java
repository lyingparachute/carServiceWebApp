package com.infoShare.carService.controllers;

import com.infoShare.carService.service.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("vehicle")
public class AddVehicleController {
    private final VehicleService vehicleService;

    public AddVehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("new")
    public String addNewVehicleForm(){
        return "add-vehicle-form";
    }

    @PostMapping("submit")
    public String addNewVehicleSubmit(){
        return "redirect:/vehicles";
    }
}
