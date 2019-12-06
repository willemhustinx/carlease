package nl.willemhustinx.carlease.customerservice.repository;

import nl.willemhustinx.carlease.customerservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    Customer findByCustomerNumber(final String relationCode);
}
