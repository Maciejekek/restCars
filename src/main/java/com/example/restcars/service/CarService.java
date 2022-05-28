package com.example.restcars.service;

import com.example.restcars.exceptions.ResourceNotFoundException;
import com.example.restcars.model.Car;
import com.example.restcars.repository.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

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

    public Car findById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car with id: "+ id + " not exist"));
    }

    public ResponseEntity<HttpStatus> delete(Car car){
        carRepository.delete(car);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public List<Car> findByColor(String color){
        List<Car> carList = carRepository.findAll()
                .stream()
                .filter(g -> g.getColor().toLowerCase(Locale.ROOT) == color.toLowerCase(Locale.ROOT))
                .collect(Collectors.toList());
    return carList;
    }


}
