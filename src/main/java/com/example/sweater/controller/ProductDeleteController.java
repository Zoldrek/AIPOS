package com.example.sweater.controller;

import com.example.sweater.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/productDelete")
public class ProductDeleteController {
    @Autowired
    ProductRepo productRepo;

    @Transactional
    @GetMapping("{idProduct}")
    public String deleteProduct(
            @PathVariable Integer idProduct
    ){
        productRepo.deleteProductByIdProduct(idProduct);
        return "redirect:productFTHL/product";
    }

}
