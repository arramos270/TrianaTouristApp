package com.example.RamirezRamosAlejandro_TrianaTouristApp.controllers;

import com.example.RamirezRamosAlejandro_TrianaTouristApp.models.Category;
import com.example.RamirezRamosAlejandro_TrianaTouristApp.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categoria")
@Validated
public class CategoryController {

    //@Valid en los parametros de los metodos

    private final CategoryService service;

    @GetMapping("/")
    public List<Category> todos() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Category uno(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/")
    public Category crear(@Valid @RequestBody Category category) {
        return service.save(category);
    }

    @PutMapping("/")
    public Category edit(@RequestBody Category category){
        return category;
    }

    @DeleteMapping("")
    public ResponseEntity<Category> delete(@RequestBody Category categoria){
        return null;
    }
    
}
