package com.example.RamirezRamosAlejandro_TrianaTouristApp.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

public class Route {

    @Id
    @GeneratedValue
    private Long id;

    //Debe ser único (Podemos usar el validador propio que hicimos para Category
    private String name;

    //Aqui vinculamos unidireccionalmente con Poi
    private List<Poi> steps;
}
