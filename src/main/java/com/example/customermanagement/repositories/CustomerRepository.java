package com.example.customermanagement.repositories;

import com.example.customermanagement.models.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Page<Customer> findAllByFirstNameContaining(String firstName, Pageable pageable);

    Page<Customer> findAllByFirstNameContainingAndProvinceId(String firstName, Long provinceId,
            Pageable pageable);
}
