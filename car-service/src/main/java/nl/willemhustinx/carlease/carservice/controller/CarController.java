package nl.willemhustinx.carlease.carservice.controller;

import nl.willemhustinx.carlease.carservice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    CarService service;

    @Autowired
    public CarController(CarService carService) {
        this.service = carService;
    }


    @GetMapping
    public ResponseEntity<List<CarDTO>> getAllCars() {
        List<CarDTO> list = service.getAllCars();
        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
    }
}
