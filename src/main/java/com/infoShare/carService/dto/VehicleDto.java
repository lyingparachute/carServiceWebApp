package com.infoShare.carService.dto;

import com.infoShare.carService.enums.Color;
import com.infoShare.carService.model.Auditable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
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

    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;

}
