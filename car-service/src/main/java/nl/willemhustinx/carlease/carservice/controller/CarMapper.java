package nl.willemhustinx.carlease.carservice.controller;

import nl.willemhustinx.carlease.carservice.model.Car;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CarMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    public Car convertToNewEntity(final CarDTO carDTO) {
        return modelMapper.map(carDTO, Car.class);
    }

    public void convertToUpdatedEntity(final CarDTO carDTO, final Car car) {
        modelMapper.map(carDTO, car);
    }

    public CarDTO convertToDTO(final Car car) {
        return modelMapper.map(car, CarDTO.class);
    }
}
