package nl.willemhustinx.leaserateservice.controller;

import io.micrometer.core.annotation.Timed;
import nl.willemhustinx.leaserateservice.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;


@RestController
@RequestMapping("/leaserate")
public class LeaserateController {

    private RestTemplate restTemplate;

    @Autowired
    public LeaserateController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("{mileage}/{duration}/{interestRate}/{carID}")
    @Timed
    public ResponseEntity<String> calculateLeaseRate(@PathVariable double mileage, @PathVariable double duration, @PathVariable double interestRate, @PathVariable Long carID) {

        ResponseEntity<CarDTO> forEntity = restTemplate.getForEntity("http://CAR-SERVICE/cars/" + carID, CarDTO.class);
        CarDTO car = forEntity.getBody();
        double nettPrice = 0;

        if (car == null) {
            throw new NotFoundException("Car not found");
        }

        try {
            nettPrice = NumberFormat.getNumberInstance(Locale.UK).parse(car.getNettPrice()).doubleValue();
        } catch (ParseException e) {
            //Foutje
        }

        if (nettPrice == 0) {
            throw new NotFoundException("NettPrice zero");
        }

        double leaseRate = (((mileage / 12) * duration) / nettPrice) + (((interestRate / 100) * nettPrice) / 12);

        return new ResponseEntity<>("Hallo, " + leaseRate, new HttpHeaders(), HttpStatus.OK);
    }
}
