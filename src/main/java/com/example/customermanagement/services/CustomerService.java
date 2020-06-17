package com.example.customermanagement.services;

import com.example.customermanagement.models.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findAllByFirstNameContaining(String firstName, Pageable pageable);

    Page<Customer> findByFirstNameAndProvince(String firstName, Long provinceId, Pageable pageable);

    void save(Customer customer);
}
