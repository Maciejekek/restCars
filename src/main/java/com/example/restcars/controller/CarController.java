package com.example.restcars.controller;

import com.example.restcars.model.Car;
import com.example.restcars.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
•do pobierania wszystkich pozycji
•do pobierania elementu po jego id
•do pobierania elementów w określonym kolorze (query)
•do dodawania pozycji
•do modyfikowania pozycji
•do modyfikowania jednego z pól pozycji (kolor)         todo
•do usuwania jeden pozycji
 */

@RestController
@RequestMapping("/app")
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

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id){
        Car car = carService.findById(id);
        return ResponseEntity.ok(car);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car carDetails){
        Car updateCar = carService.findById(id);

        updateCar.setMark(carDetails.getMark());
        updateCar.setModel(carDetails.getModel());
        updateCar.setColor(carDetails.getColor());

        return ResponseEntity.ok(updateCar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCar(@PathVariable Long id){
        Car car = carService.findById(id);
        return carService.delete(car);
    }

    @GetMapping("/color/{color}")
    public ResponseEntity<List<Car>> getCarsByColors(@PathVariable String color){
        List<Car> carList = carService.findByColor(color);
        return ResponseEntity.ok(carList);
    }


}


