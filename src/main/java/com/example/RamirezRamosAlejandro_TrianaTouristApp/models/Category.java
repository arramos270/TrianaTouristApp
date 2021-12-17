package com.example.RamirezRamosAlejandro_TrianaTouristApp.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Category {

    @Id
    @GeneratedValue
    private Long id;

    //Debe ser único (validador propio) y no vacío (No Null)
    private String name;
}
