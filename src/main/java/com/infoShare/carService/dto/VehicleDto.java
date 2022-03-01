package com.infoShare.carService.dto;

import com.infoShare.carService.enums.Color;
import lombok.*;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto {
    private UUID id;
    private String name;
    private String registrationNumber;
    private boolean isFixed;
    private Color color;
    private int productionDate;
}
