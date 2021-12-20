package com.example.RamirezRamosAlejandro_TrianaTouristApp.controllers;

import com.example.RamirezRamosAlejandro_TrianaTouristApp.dtos.models.CreateRouteDto;
import com.example.RamirezRamosAlejandro_TrianaTouristApp.dtos.converters.RouteDtoConverter;
import com.example.RamirezRamosAlejandro_TrianaTouristApp.models.Route;
import com.example.RamirezRamosAlejandro_TrianaTouristApp.services.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/route")
@Validated
public class RouteController {

    private final RouteService service;
    private final RouteDtoConverter dtoConverter;

    @GetMapping("/")
    public ResponseEntity<List<Route>> findAll() {
        return ResponseEntity.status(200).body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Route> findOne(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Route> create(@Valid @RequestBody CreateRouteDto nuevaRuta) {
        Route nueva= dtoConverter.createRouteDtoToRoute(nuevaRuta);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(nueva));
    }

    @PutMapping("/{id}") //Si algo falla se encarga el servicio de lanzar la excepción
    public ResponseEntity<Route> edit(@RequestBody Route rutaAEditar) {
        return ResponseEntity.ok().body(service.edit(rutaAEditar));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
