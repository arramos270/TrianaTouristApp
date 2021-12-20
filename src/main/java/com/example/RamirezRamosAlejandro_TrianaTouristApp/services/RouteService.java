package com.example.RamirezRamosAlejandro_TrianaTouristApp.services;

import com.example.RamirezRamosAlejandro_TrianaTouristApp.repos.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final RouteRepository repositorio;
}
