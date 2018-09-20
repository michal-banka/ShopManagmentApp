package com.app.validation;

import com.app.models.utility.Customer;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CustomerValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(Customer.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Customer customer = (Customer) o;

        if(!customer.getName().matches("[A-Z]+( [A-Z]+)*"))
        {
            errors.rejectValue("name", "You can use only upper letters and spaces!");
        }

        if(!customer.getSurname().matches("[A-Z]+( [A-Z]+)*"))
        {
            errors.rejectValue("surname", "You can use only upper letters and spaces!");
        }

        if(customer.getAge() < 18)
        {
            errors.rejectValue("age", "To register you must be at least 18!");
        }
    }
}
