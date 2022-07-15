package com.infoShare.carService.controllers;

import com.infoShare.carService.dto.CreateVehicleDto;
import com.infoShare.carService.service.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;

@Controller
@RequestMapping("vehicle")
public class NewVehicleController {
    private final VehicleService vehicleService;

    public NewVehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("new")
    public String getNewVehicleForm(Model model){
        model.addAttribute("vehicle", new CreateVehicleDto());
        return "new-vehicle-form";
    }

    @PostMapping(value = "new")
    public String createVehicle(@Valid @ModelAttribute("vehicle") CreateVehicleDto vehicle, Model model,
                                Errors errors) {
        if (errors.hasErrors()) {
            return "new-vehicle-form";
        }
        model.addAttribute("vehicle", vehicleService.saveVehicle(vehicle));
        return "redirect:/vehicles";
    }
}
