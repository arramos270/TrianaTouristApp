package com.example.RamirezRamosAlejandro_TrianaTouristApp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    //Debe ser único (validador propio) y no vacío (No Null)
    private String name;

    public Category(String name) {
        this.name = name;
    }

}
