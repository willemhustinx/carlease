package nl.willemhustinx.carlease.carservice.service;

import nl.willemhustinx.carlease.carservice.controller.CarDTO;
import nl.willemhustinx.carlease.carservice.controller.CarMapper;
import nl.willemhustinx.carlease.carservice.exception.NotFoundException;
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
        List<Car> carList = repository.findAll();

        return carList.stream().map(mapper::convertToDTO).collect(Collectors.toList());
    }

    public CarDTO getCarById(Long carID) {
        Car foundCar = repository.findByCarID(carID);

        if (foundCar != null) {
            return mapper.convertToDTO(foundCar);
        }
        throw new NotFoundException("Car not found");
    }

}
