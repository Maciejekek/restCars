package com.example.restcars;

import com.example.restcars.model.Car;
import com.example.restcars.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestCarsApplication implements CommandLineRunner {

    public RestCarsApplication(CarService carService) {
        this.carService = carService;
    }

    public static void main(String[] args) {
        SpringApplication.run(RestCarsApplication.class, args);
    }

    private final CarService carService;
    @Override
    public void run(String... args) throws Exception {
//        Car car = new Car();
//        car.setMark("FSO");
//        car.setModel("Polonez");
//        car.setColor("Red");
//        carService.save(car);
//
//        Car car2 = new Car();
//        car2.setMark("Lada");
//        car2.setModel("Lada");
//        car2.setColor("White");
//        carService.save(car2);
//
//        Car car3 = new Car();
//        car3.setMark("FCS");
//        car3.setModel("Zuk");
//        car3.setColor("Green");
//        carService.save(car3);
    }
}
