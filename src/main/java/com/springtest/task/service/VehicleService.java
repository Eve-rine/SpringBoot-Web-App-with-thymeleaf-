package com.springtest.task.service;

import com.springtest.task.entity.Vehicle;
import com.springtest.task.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    private VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    // save vehicle
    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    // get vehicles
    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }


}
