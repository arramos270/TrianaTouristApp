package com.example.RamirezRamosAlejandro_TrianaTouristApp.errors.exceptions;

public class PoiRepeatedOnSameRouteException extends RuntimeException {

    public PoiRepeatedOnSameRouteException(String id) {
        super(String.format("El Poi con id %s que estás intentando meter en esta ruta, ya ha sido introducido antes.", id));
    }
}
