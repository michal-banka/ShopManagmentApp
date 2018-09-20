package com.app.service;

import com.app.models.utility.Country;
import com.app.models.utility.Customer;
import java.util.Optional;

public interface CustomerService {
    void addOrUpdateCustomer(Customer customer);
    void deleteCustomer(Long id);
    Optional<Customer> getCustomerById(Long id);
    Optional<Customer> getCustomerByNameSurnameAndCountry(String name, String surname, Country country);
}
