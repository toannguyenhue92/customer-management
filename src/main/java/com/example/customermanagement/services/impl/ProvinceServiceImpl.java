package com.example.customermanagement.services.impl;

import java.util.LinkedList;
import java.util.List;
import com.example.customermanagement.models.Province;
import com.example.customermanagement.repositories.ProvinceRepository;
import com.example.customermanagement.services.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public List<Province> findAll() {
        List<Province> provinces = new LinkedList<>();
        for (Province p : provinceRepository.findAll()) {
            provinces.add(p);
        }
        return provinces;
    }

    @Override
    public Province findById(Long id) {
        return provinceRepository.findById(id).orElse(null);
    }


    @Override
    public void save(Province t) {
        provinceRepository.save(t);
    }

}
