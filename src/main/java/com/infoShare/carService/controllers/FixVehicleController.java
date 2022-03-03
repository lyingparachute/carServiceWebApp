package com.infoShare.carService.controllers;

import com.infoShare.carService.dto.VehicleDto;
import com.infoShare.carService.service.VehicleService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        return "vehicle-search";
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
    public String getVehicleSearchView() {
        return "vehicle-search";
    }

    @GetMapping("fix/search")
    public String getRegultOfSearch(@Param("registration") String registration, Model model) {
        model.addAttribute("vehiclesList", vehicleService.findByRegistrationNumber(registration));
        model.addAttribute("registration", registration);
        model.addAttribute("describtion", "Search describtion for '" + registration + "':");
        return "vehicle-search-result";
    }
}
