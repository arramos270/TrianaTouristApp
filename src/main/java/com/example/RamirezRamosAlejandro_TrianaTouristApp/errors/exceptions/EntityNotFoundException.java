package com.example.RamirezRamosAlejandro_TrianaTouristApp.errors.exceptions;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String id, Class clazz) {
        super(String.format("No se puede encontrar una entidad del tipo %s con ID: %s", clazz.getName(), id));
    }
}