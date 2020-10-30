package com.example.sweater.controller;

import com.example.sweater.domain.Customer;
import com.example.sweater.domain.User;
import com.example.sweater.repos.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customerList")
public class CustomerEditController {
    @Autowired
    CustomerRepo customerRepo;

    @GetMapping
    public String CustomerEditController(Model model) {
        model.addAttribute("customers",customerRepo.findAll());
        return "customerFTHL/customerList";
    }

    @GetMapping("{idCustomer}")
    public String productEdit(@PathVariable Integer idCustomer, Model model) {
        model.addAttribute("customers", customerRepo.findCustomerByIdCustomer(idCustomer));
        return "customerFTHL/customerEdit";
    }

    @PostMapping("{idCustomer}")
    public String userSave(
            @RequestParam String customerName,
            @RequestParam String year,
            @AuthenticationPrincipal User user,
            @PathVariable Integer idCustomer) {
        Customer customer = new Customer(customerName,year,idCustomer,user);
        customerRepo.save(customer);
        return "redirect:/customer";
    }
}
