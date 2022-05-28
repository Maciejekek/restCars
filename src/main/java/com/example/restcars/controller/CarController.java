package com.example.restcars.controller;

import com.example.restcars.model.Car;
import com.example.restcars.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class CarController {

    public CarController(CarService carService) {
        this.carService = carService;
    }

    private final CarService carService;

    @GetMapping
    public List<Car> getAllCars(){
        return carService.findAll();
    }

    @PostMapping
    public Car createCar(@RequestBody Car car){
        return carService.save(car);
    }

    @GetMapping
}


