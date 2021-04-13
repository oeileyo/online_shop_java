package com.example.demo.controller;

import com.example.demo.entity.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.ManufacturerService;

import java.util.List;

public class ManufacturerController {
    private ManufacturerService manufacturerService;

    @Autowired
    public ManufacturerController(ManufacturerService manufacturerService){
        this.manufacturerService = manufacturerService;
    }

    @PostMapping(value = "/model")
    public ResponseEntity<?> create(@RequestBody Manufacturer manufacturer){
        manufacturerService.create(manufacturer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/manufacturer")
    public ResponseEntity<List<Manufacturer>> findAll(){
        final List<Manufacturer> manufacturerList = manufacturerService.findAll();

        return manufacturerList != null && !manufacturerList.isEmpty()
                ? new ResponseEntity<>(manufacturerList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/manufacturer/{id}")
    public ResponseEntity<Manufacturer> find(@PathVariable(name="id") Long id){
        final Manufacturer manufacturer = manufacturerService.find(id);

        return manufacturer != null
                ? new ResponseEntity<>(manufacturer, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/manufacturer")
    public ResponseEntity<?> deleteById(@PathVariable(name="id") Long id){
        manufacturerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
