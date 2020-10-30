package com.example.sweater.controller;

import com.example.sweater.domain.Product;
import com.example.sweater.domain.User;
import com.example.sweater.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {
    @Autowired
    private ProductRepo productRepo;

    @GetMapping("/product")
    public String ProductList(Model model) {
        model.addAttribute("products",productRepo.findAll());
        return "productFTHL/product";
    }

   @PostMapping("/product")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String modelProduct,
            @RequestParam String vin,
            @RequestParam String number,Model model
    ) {
        if(modelProduct.length()>0 && vin.length()>0 && number.length()>0) {
            Product product = new Product(modelProduct, vin, number, user);
            productRepo.save(product);
        }
        model.addAttribute("products",productRepo.findAll());
        return "productFTHL/product";
    }
}
