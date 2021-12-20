package com.example.RamirezRamosAlejandro_TrianaTouristApp.controllers;


import com.example.RamirezRamosAlejandro_TrianaTouristApp.dtos.models.CreatePoiDto;
import com.example.RamirezRamosAlejandro_TrianaTouristApp.dtos.converters.PoiDtoConverter;
import com.example.RamirezRamosAlejandro_TrianaTouristApp.models.Poi;
import com.example.RamirezRamosAlejandro_TrianaTouristApp.services.PoiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/poi")
@Validated
public class PoiController {

    private PoiService service;
    private PoiDtoConverter dtoConverter;

    @GetMapping("/")
    public ResponseEntity<List<Poi>> findAll() {
        return ResponseEntity.status(200).body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Poi> findOne(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Poi> create(@Valid @RequestBody CreatePoiDto nuevoPoi) {
        Poi nuevo= dtoConverter.createPoiDtoToPoi(nuevoPoi);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(nuevo));
    }

    @PutMapping("/{id}") //Si algo falla se encarga el servicio de lanzar la excepción
    public ResponseEntity<Poi> edit(@RequestBody Poi editedPoi) {
        return ResponseEntity.ok().body(service.edit(editedPoi));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
