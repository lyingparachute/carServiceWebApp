package com.infoShare.carService.model;

import com.infoShare.carService.enums.Color;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = Vehicle.TABLE_NAME)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle extends Auditable {
    public static final String TABLE_NAME = "vehicle";
    public static final String COLUMN_PREFIX = "v_";

    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    @Column(name = COLUMN_PREFIX + "id")
    private UUID id;

    @Column(name = COLUMN_PREFIX + "name", nullable = false)
    private String name;

    @Column(name = COLUMN_PREFIX + "registrationNumber", unique = true, nullable = false, length = 9)
    private String registrationNumber;

    @Column(name = COLUMN_PREFIX + "isFixed")
    private boolean isFixed;

    @Column(name = COLUMN_PREFIX + "color")
    private Color color;

    @Column(name = COLUMN_PREFIX + "productionDate")
    private int productionDate;

    public Vehicle(String name, String registrationNumber) {
        this.name = name;
        this.registrationNumber = registrationNumber;
    }
}
