package com.springtest.task.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vehicle_details")
public class Vehicle {
    @Id
    @GeneratedValue
    private int Id;
    private String vehicle_registration;
    private String vehicle_type;
    private String vehicle_make;

}
