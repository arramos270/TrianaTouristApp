package com.example.RamirezRamosAlejandro_TrianaTouristApp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Poi {

    //No puede existir un mismo punto de interés 2 veces. ¿Podemos crear un dto para comparar? ¿O podemos comparar antes de hacer el save en el metodo de guardar?

    @Id
    @GeneratedValue
    private Long id;

    //No nulo
    private String name;

    //Formato adecuado de Google Maps (Validador propio, coger el del ultimo ejercicio)
    private String location;
    private String description;
    private LocalDate date;

    //Aqui vinculamos unidireccionalmente con Category
    //La categoría debe ser una categoría existente (Validador propio)
    @OneToMany
    @JoinColumn(name = "poi_id")
    private Category category;

    //A partir de aquí, poner la notación url

    /* Por si el día de mañana queremos guardar más fotos,
    usaremos una notación que coja un array de atributos
    (sí, como en el ejemplo anterior) */

    //Obligatoria
    private String coverPhoto;

    //No obligatoria
    private String photo2;

    //No obligatoria
    private String photo3;

    public Poi(String name, String location, String description, LocalDate date, Category category, String coverPhoto, String photo2, String photo3) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.date = date;
        this.category = category;
        this.coverPhoto = coverPhoto;
        this.photo2 = photo2;
        this.photo3 = photo3;
    }
}
