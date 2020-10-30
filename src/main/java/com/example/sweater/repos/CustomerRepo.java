package com.example.sweater.repos;

import com.example.sweater.domain.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepo extends CrudRepository<Customer, Long> {
    List<Customer> findCustomerByIdCustomer(Integer idCustomer);

    void deleteCustomerByIdCustomer(Integer idCustomer);
}
