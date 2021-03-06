package com.example.sweater.controller;

import com.example.sweater.repos.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customerDelete")
public class CustomerDeleteController {
    @Autowired
    CustomerRepo customerRepo;

    @Transactional
    @GetMapping("{idCustomer}")
    public String deleteCustomer(
            @PathVariable Integer idCustomer
    ){
        customerRepo.deleteCustomerByIdCustomer(idCustomer);
        return "redirect:customerFTHL/customer";
    }
}
