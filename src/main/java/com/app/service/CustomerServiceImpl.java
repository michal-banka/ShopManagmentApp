package com.app.service;

import com.app.models.utility.Country;
import com.app.models.utility.Customer;
import com.app.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Override
    public void addOrUpdateCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Optional<Customer> getCustomerByNameSurnameAndCountry(String name, String surname, Country country) {
        return customerRepository.getCustomerByNameAndSurnameAndCountry(name,surname,country);
    }
}
