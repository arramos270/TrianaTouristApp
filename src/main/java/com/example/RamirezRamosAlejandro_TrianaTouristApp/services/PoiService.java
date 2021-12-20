package com.example.RamirezRamosAlejandro_TrianaTouristApp.services;

import com.example.RamirezRamosAlejandro_TrianaTouristApp.repos.PoiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PoiService {

    private final PoiRepository repositorio;

}
