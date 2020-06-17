package com.example.customermanagement.controllers;

import com.example.customermanagement.models.Province;
import com.example.customermanagement.services.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    @GetMapping(path = "/provinces")
    public ModelAndView showAll() {
        ModelAndView modelAndView = new ModelAndView("province/list");
        modelAndView.addObject("provinces", provinceService.findAll());
        return modelAndView;
    }

    @GetMapping(path = "/province/create")
    public ModelAndView showCreateProvinceForm() {
        ModelAndView modelAndView = new ModelAndView("province/create");
        modelAndView.addObject("province", new Province());
        return modelAndView;
    }

    @PostMapping(path = "/province/save")
    public String saveNewProvince(@ModelAttribute Province province) {
        provinceService.save(province);
        return "redirect:/provinces";
    }
}
