package com.springtest.task.controller;

import com.springtest.task.entity.Vehicle;
import com.springtest.task.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// add  public to the path
@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService service;

    // save vehicle
    @PostMapping("/add")
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return service.saveVehicle(vehicle);
    }

    // get vehicles
    @GetMapping("/list")
    public List<Vehicle> getVehicles(){
        return service.getVehicles();
    }



}
