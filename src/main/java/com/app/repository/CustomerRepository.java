package com.app.repository;

import com.app.models.utility.Country;
import com.app.models.utility.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> getCustomerByNameAndSurnameAndCountry(String name, String surname, Country country);
}
