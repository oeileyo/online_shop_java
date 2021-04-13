package com.example.demo.controller;

import com.example.demo.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.RoleService;

import java.util.List;

public class RoleController {
    private RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }

    @PostMapping(value = "/role")
    public ResponseEntity<?> create(@RequestBody Role role){
        roleService.create(role);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/role")
    public ResponseEntity<List<Role>> findAll(){
        final List<Role> roleList = roleService.findAll();

        return roleList != null && !roleList.isEmpty()
                ? new ResponseEntity<>(roleList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/role/{id}")
    public ResponseEntity<Role> find(@PathVariable(name="id") Long id){
        final Role role = roleService.find(id);

        return role != null
                ? new ResponseEntity<>(role, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/role")
    public ResponseEntity<?> deleteById(@PathVariable(name="id") Long id){
        roleService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
