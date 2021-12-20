package com.example.RamirezRamosAlejandro_TrianaTouristApp.dtos.converters;

import com.example.RamirezRamosAlejandro_TrianaTouristApp.dtos.models.CreateRouteDto;
import com.example.RamirezRamosAlejandro_TrianaTouristApp.models.Route;
import org.springframework.stereotype.Component;

@Component
public class RouteDtoConverter {

    public Route createRouteDtoToRoute(CreateRouteDto r) {
        return new Route(
                r.getName(),
                r.getSteps()
        );
    }
}
