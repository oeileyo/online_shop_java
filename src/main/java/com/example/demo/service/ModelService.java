package com.example.demo.service;

import com.example.demo.entity.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.ModelRepository;

import java.util.List;

@Service
public class ModelService {
    @Autowired
    private ModelRepository modelRepository;

    public void create(Model model){
        modelRepository.save(model);
    }

    public List<Model> findAll(){
        return modelRepository.findAll();
    }

    public Model find(Long id){
        return modelRepository.getOne(id);
    }

    public void delete(Long id){ modelRepository.deleteById(id); }
}
