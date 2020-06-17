package com.example.customermanagement.controllers;

import java.util.Optional;
import com.example.customermanagement.models.Customer;
import com.example.customermanagement.models.Province;
import com.example.customermanagement.services.CustomerService;
import com.example.customermanagement.services.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProvinceService provinceService;

    @GetMapping(path = "/customers")
    public ModelAndView showCustomers(@RequestParam Optional<String> search,
            @PageableDefault(size = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("customer/list");
        Page<Customer> customers;
        if (search.isPresent()) {
            customers = customerService.findAllByFirstNameContaining(search.get(), pageable);
            modelAndView.addObject("search", search.get());
        } else {
            customers = customerService.findAll(pageable);
        }
        modelAndView.addObject("customers", customers);
        modelAndView.addObject("provinces", provinceService.findAll());
        return modelAndView;
    }

    @GetMapping(path = "/customer/create")
    public ModelAndView showCreateCusomerForm() {
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("provinces", provinceService.findAll());
        return modelAndView;
    }

    @PostMapping(path = "/customer/save")
    public String saveNewCustomer(@ModelAttribute Customer customer,
            @RequestParam Long provinceId) {
        Province province = provinceService.findById(provinceId);
        customer.setProvince(province);
        customerService.save(customer);
        return "redirect:/customers";
    }

}
