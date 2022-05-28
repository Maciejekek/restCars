package com.example.restcars.service;

import com.example.restcars.model.Car;
import com.example.restcars.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService{

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    private final CarRepository carRepository;

    public List<Car> findAll(){
        return carRepository.findAll();
    }

    public Car save(Car car) {
        return carRepository.save(car);
    }
}
