package com.example.RamirezRamosAlejandro_TrianaTouristApp.dtos.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategoryDto {

    //Debe ser único (restriccion aplicada en el servicio)
    @NotNull
    private String name;
}
