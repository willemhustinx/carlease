package nl.willemhustinx.carlease.customerservice.service;


import nl.willemhustinx.carlease.customerservice.exception.NotFoundException;
import nl.willemhustinx.carlease.customerservice.controller.CustomerDTO;
import nl.willemhustinx.carlease.customerservice.controller.CustomerMapper;
import nl.willemhustinx.carlease.customerservice.model.Customer;
import nl.willemhustinx.carlease.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    @Autowired
    public CustomerService(CustomerRepository repository, CustomerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customerList = repository.findAll();

        return customerList.stream().map(mapper::convertToDTO).collect(Collectors.toList());
    }

    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = repository.save(mapper.convertToNewEntity(customerDTO));
        return mapper.convertToDTO(customer);
    }

    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        Customer foundCustomer = repository.findByCustomerNumber(customerDTO.getCustomerNumber());

        if (foundCustomer != null) {
            mapper.convertToUpdatedEntity(customerDTO, foundCustomer);
            Customer updateCustomer = repository.save(foundCustomer);
            return mapper.convertToDTO(updateCustomer);
        }
        throw new NotFoundException("Customer not found");
    }

    public boolean deleteCustomer(String customerNumber) {
        Customer foundCustomer = repository.findByCustomerNumber(customerNumber);

        if (foundCustomer != null) {
            repository.delete(foundCustomer);
            return true;
        }
        throw new NotFoundException("Customer not found");

    }
}
