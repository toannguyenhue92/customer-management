package com.example.customermanagement.services.impl;

import com.example.customermanagement.models.Customer;
import com.example.customermanagement.repositories.CustomerRepository;
import com.example.customermanagement.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable) {
        return customerRepository.findAllByFirstNameContaining(firstname, pageable);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Page<Customer> findByFirstNameAndProvince(String firstName, Long provinceId,
            Pageable pageable) {
        customerRepository.findAllByFirstNameContainingAndProvinceId(firstName, provinceId,
                pageable);
        return null;
    }

}
