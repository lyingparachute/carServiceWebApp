package com.infoShare.carService.controllers;

import com.infoShare.carService.service.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("vehicles")
public class VehiclesController {
    private final VehicleService vehicleService;

    public VehiclesController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping()
    public String getVehiclesToFix(Model model){
        model.addAttribute("vehiclesList", vehicleService.findNotFixedVehicles());
        return "vehicles";
    }

    @GetMapping("fixed")
    public String getFixedVehicles(Model model){
        model.addAttribute("fixedVehicles", vehicleService.findFixedVehicles());
        return "vehicles-fixed";
    }
}
