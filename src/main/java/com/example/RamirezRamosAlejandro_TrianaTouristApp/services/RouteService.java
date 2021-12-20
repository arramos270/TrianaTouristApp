package com.example.RamirezRamosAlejandro_TrianaTouristApp.services;

import com.example.RamirezRamosAlejandro_TrianaTouristApp.errors.exceptions.EntityNotFoundException;
import com.example.RamirezRamosAlejandro_TrianaTouristApp.errors.exceptions.PoiRepeatedOnSameRouteException;
import com.example.RamirezRamosAlejandro_TrianaTouristApp.models.Category;
import com.example.RamirezRamosAlejandro_TrianaTouristApp.models.Poi;
import com.example.RamirezRamosAlejandro_TrianaTouristApp.models.Route;
import com.example.RamirezRamosAlejandro_TrianaTouristApp.repos.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final RouteRepository repositorio;

    public List<Route> findAll(){
        return repositorio.findAll();
    }

    public Route findById(Long id){
        return repositorio.findById(id).orElse(null);
    }

    public Route edit(Route editedRoute) {
        Route antiguaRuta= repositorio.findById(editedRoute.getId()).orElse(null);
        antiguaRuta.setName(editedRoute.getName());
        antiguaRuta.setSteps(editedRoute.getSteps());
        return editedRoute;
    }

    public Route save(Route newRoute) {
        repositorio.save(newRoute);
        return newRoute;
    }

    public void delete(Long id) {
        repositorio.deleteById(id);
    }

    public boolean addPoiToRoute(Poi newPoiToAdd, Route route) {
        route.getSteps().forEach((p) -> {
            if(p.getId() == newPoiToAdd.getId()) {
                throw new PoiRepeatedOnSameRouteException(newPoiToAdd.getId().toString());
            }
        });

        route.getSteps().add(newPoiToAdd);
        return true;
    }

    public void deletePoiFromRoute(Poi poiToDelete, Route route) {
        route.getSteps().remove(poiToDelete);
    }

}
