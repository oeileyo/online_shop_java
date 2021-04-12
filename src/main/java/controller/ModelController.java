package controller;

import entity.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ModelService;

import java.util.List;

public class ModelController {
    private ModelService modelService;

    @Autowired
    public ModelController(ModelService modelService){
        this.modelService = modelService;
    }

    @PostMapping(value = "/model")
    public ResponseEntity<?> create(@RequestBody Model model){
        modelService.create(model);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/model")
    public ResponseEntity<List<Model>> findAll(){
        final List<Model> modelList = modelService.findAll();

        return modelList != null && !modelList.isEmpty()
                ? new ResponseEntity<>(modelList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/model/{id}")
    public ResponseEntity<Model> find(@PathVariable(name="id") Long id){
        final Model model = modelService.find(id);

        return model != null
                ? new ResponseEntity<>(model, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/model")
    public ResponseEntity<?> deleteById(@PathVariable(name="id") Long id){
        modelService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
