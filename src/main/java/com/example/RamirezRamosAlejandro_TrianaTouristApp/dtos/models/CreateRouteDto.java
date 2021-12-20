package com.example.RamirezRamosAlejandro_TrianaTouristApp.dtos.models;

import com.example.RamirezRamosAlejandro_TrianaTouristApp.models.Poi;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRouteDto {

    //Debe ser único (restricción aplicada en el servicio)
    private String name;

    private List<Poi> steps;

}
