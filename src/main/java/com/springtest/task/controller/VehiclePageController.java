package com.springtest.task.controller;

import com.springtest.task.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.HttpHeaders;



@RestController
public class VehiclePageController {

    private final String backendUrl = "http://localhost:8082/vehicles/list";
    private final String backendAddUrl = "http://localhost:8082/vehicles/add";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/vehicles")
    public ModelAndView fetchDataFromBackend() {
        Vehicle[] vehicles = restTemplate.getForObject(backendUrl, Vehicle[].class);

        ModelAndView modelAndView = new ModelAndView("vehicles");

        modelAndView.addObject("vehicles", vehicles);

        return modelAndView;
    }

    @PostMapping("/vehicles/save")
    public String addVehicle(@RequestParam("vehicle_registration") String registration,
                             @RequestParam("vehicle_type") String type,
                             @RequestParam("vehicle_make") String make) {


        // Create a new Vehicle object
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicle_registration(registration);
        vehicle.setVehicle_type(type);
        vehicle.setVehicle_make(make);

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);


        HttpEntity<Vehicle> requestEntity = new HttpEntity<>(vehicle, headers);

        restTemplate.postForObject(backendAddUrl, requestEntity, Void.class);

        return "redirect:/vehicles";
    }

}
