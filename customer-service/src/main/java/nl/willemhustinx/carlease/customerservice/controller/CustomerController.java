package nl.willemhustinx.carlease.customerservice.controller;

import io.micrometer.core.annotation.Timed;
import nl.willemhustinx.carlease.customerservice.exception.NotFoundException;
import nl.willemhustinx.carlease.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService service;

    private RestTemplate restTemplate;

    @Autowired
    public CustomerController(CustomerService customerService, RestTemplate restTemplate) {
        this.service = customerService;
        this.restTemplate = restTemplate;
    }


    @GetMapping
    @Timed
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<CustomerDTO> list = service.getAllCustomers();

        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://CAR-SERVICE/cars", String.class);

        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {

        CustomerDTO newCustomer = service.createCustomer(customerDTO);
        return new ResponseEntity<>(newCustomer, new HttpHeaders(), HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDTO) {
        try {
            return new ResponseEntity<>(service.updateCustomer(customerDTO), HttpStatus.OK);
        } catch (NotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    @DeleteMapping("/delete/{relationNumber}")
    public boolean deleteCustomer(@PathVariable String relationNumber) {
        try {
            return service.deleteCustomer(relationNumber);
        } catch (NotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }
}
