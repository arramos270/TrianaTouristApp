package com.example.RamirezRamosAlejandro_TrianaTouristApp.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

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
    private Category category;

    //A partir de aquí, poner la notación @url

    /* Por si el día de mañana queremos guardar más fotos,
    usaremos una notación que coja un array de atributos
    (sí, como en el ejemplo anterior) */

    //Obligatoria
    private String  coverPhoto;

    //No obligatoria
    private String photo2;

    //No obligatoria
    private String photo3;
}
