package nl.willemhustinx.carlease.customerservice.controller;

import nl.willemhustinx.carlease.customerservice.Exception.NotFoundException;
import nl.willemhustinx.carlease.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    CustomerService service;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.service = customerService;
    }


    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<CustomerDTO> list = service.getAllCustomers();

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
