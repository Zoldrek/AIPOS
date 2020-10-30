package com.example.sweater.repos;

import com.example.sweater.domain.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepo extends CrudRepository<Product, Long> {
    List<Product> findProductByIdProduct(Integer idProduct);

    void deleteProductByIdProduct(Integer idProduct);
}
