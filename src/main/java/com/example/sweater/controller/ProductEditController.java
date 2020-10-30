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
@RequestMapping("/productList")
public class ProductEditController {
    @Autowired
    ProductRepo productRepo;

    @GetMapping
    public String ProductEditController(Model model) {
        model.addAttribute("products",productRepo.findAll());
        return "productFTHL/productList";
    }

    @GetMapping("{idProduct}")
    public String productEdit(@PathVariable Integer idProduct, Model model) {
        model.addAttribute("products", productRepo.findProductByIdProduct(idProduct));
        return "productFTHL/productEdit";
    }

    @PostMapping("{idProduct}")
    public String userSave(
            @RequestParam String vin,
            @RequestParam String number,
            @RequestParam String modelProduct,
            @AuthenticationPrincipal User user,
            @PathVariable Integer idProduct) {
        Product product = new Product(idProduct,vin,number,modelProduct,user);
        productRepo.save(product);
        return "redirect:/product";
    }
}
