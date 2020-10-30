package com.example.sweater.controller;

import com.example.sweater.domain.Customer;
import com.example.sweater.domain.User;
import com.example.sweater.repos.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {
    @Autowired
    private CustomerRepo customerRepo;

    @GetMapping("/customer")
    public String main(Model model) {
        model.addAttribute("customers", customerRepo.findAll());
        return "customerFTHL/customer";
    }

    @PostMapping("/customer")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String customerName,
            @RequestParam String year,Model model
    ) {
        if(customerName.length()>0 && year.length()>0) {
            Customer customer = new Customer(customerName, year, user);
            customerRepo.save(customer);
        }
        model.addAttribute("customers", customerRepo.findAll());
        return "customerFTHL/customer";
    }
}