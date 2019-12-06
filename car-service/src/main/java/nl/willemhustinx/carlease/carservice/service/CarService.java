package nl.willemhustinx.carlease.carservice.service;

import nl.willemhustinx.carlease.carservice.controller.CarDTO;
import nl.willemhustinx.carlease.carservice.controller.CarMapper;
import nl.willemhustinx.carlease.carservice.model.Car;
import nl.willemhustinx.carlease.carservice.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    private final CarRepository repository;
    private final CarMapper mapper;

    @Autowired
    public CarService(CarRepository repository, CarMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<CarDTO> getAllCars() {
        List<Car> customerList = repository.findAll();

        return customerList.stream().map(mapper::convertToDTO).collect(Collectors.toList());
    }

}
