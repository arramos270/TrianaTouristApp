package com.example.RamirezRamosAlejandro_TrianaTouristApp.errors.exceptions;

public class UniqueCategoryNameException extends RuntimeException{

    public UniqueCategoryNameException(String nombre){
        super(String.format("Ya existe una categoría con nombre %s", nombre));
    }
}
