package nl.willemhustinx.carlease.carservice.repository;

import nl.willemhustinx.carlease.carservice.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {
    Car findByCarID(final Long carID);
}
