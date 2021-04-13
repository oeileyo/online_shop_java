package com.example.demo.service;

import com.example.demo.entity.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.ManufacturerRepository;

import java.util.List;

@Service
public class ManufacturerService {
    @Autowired
    private ManufacturerRepository manufacturerRepository;

    public void create(Manufacturer manufacturer){
        manufacturerRepository.save(manufacturer);
    }

    public List<Manufacturer> findAll(){
        return manufacturerRepository.findAll();
    }

    public Manufacturer find(Long id){
        return manufacturerRepository.getOne(id);
    }

    public void delete(Long id){ manufacturerRepository.deleteById(id); }
}

