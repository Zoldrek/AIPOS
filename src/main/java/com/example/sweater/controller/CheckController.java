package com.example.sweater.controller;

import com.example.sweater.domain.Check_Product;
import com.example.sweater.domain.User;
import com.example.sweater.repos.ProductRepo;
import com.example.sweater.repos.CheckRepo;
import com.example.sweater.repos.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckController {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private CheckRepo checkRepo;

    @GetMapping("/check")
    public String main(Model model) {
        model.addAttribute("products", productRepo.findAll());
        model.addAttribute("customers", customerRepo.findAll());
        model.addAttribute("checks", checkRepo.findAll());
        return "check";
    }

    @PostMapping("/check")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String customerName, String vin,
            @RequestParam String result, Model model
    ) {
        if(customerName.length()>0 && vin.length()>0) {
            Check_Product check = new Check_Product(customerName, vin, result, user);
            checkRepo.save(check);
        }
        model.addAttribute("checks",checkRepo.findAll());
        return "check";
    }
}
