package com.example.RamirezRamosAlejandro_TrianaTouristApp.controllers;

import com.example.RamirezRamosAlejandro_TrianaTouristApp.dtos.models.CreateCategoryDto;
import com.example.RamirezRamosAlejandro_TrianaTouristApp.dtos.converters.CategoryDtoConverter;
import com.example.RamirezRamosAlejandro_TrianaTouristApp.models.Category;
import com.example.RamirezRamosAlejandro_TrianaTouristApp.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    private final CategoryDtoConverter dtoConverter;

    @GetMapping("/")
    public ResponseEntity<List<Category>> findAll() {
        return ResponseEntity.status(200).body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findOne(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Category> create(@Valid @RequestBody CreateCategoryDto nuevaCategoria) {
        Category nueva= dtoConverter.createCategoryDtoToCategory(nuevaCategoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(nueva));
    }

    @PutMapping("/{id}") //Si algo falla se encarga el servicio de lanzar la excepción
    public ResponseEntity<Category> edit(@RequestBody Category category) {
        return ResponseEntity.ok().body(service.edit(category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
