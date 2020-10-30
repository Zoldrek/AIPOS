package com.example.sweater.repos;

import com.example.sweater.domain.Check_Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CheckRepo extends CrudRepository<Check_Product, Long> {
    List<Check_Product> findByVin(String vin);
}
