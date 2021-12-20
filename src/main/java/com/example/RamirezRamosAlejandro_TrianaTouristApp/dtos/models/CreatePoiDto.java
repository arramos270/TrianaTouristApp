package com.example.RamirezRamosAlejandro_TrianaTouristApp.dtos.models;

import com.example.RamirezRamosAlejandro_TrianaTouristApp.models.Category;
import com.example.RamirezRamosAlejandro_TrianaTouristApp.validation.anotations.CorrectLocationFormat;
import com.example.RamirezRamosAlejandro_TrianaTouristApp.validation.anotations.Url;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor @AllArgsConstructor
@Url.List({
        @Url(
                url = "coverPhoto"
        ),
        @Url(
                url = "photo2"

        ),
        @Url(
                url = "photo3"
        )
})
public class CreatePoiDto {

    @NotNull
    private String name;

    @CorrectLocationFormat
    private String location;
    private String description;
    private LocalDate date;

    //Aqui vinculamos unidireccionalmente con Category
    //La categoría debe ser una categoría existente (Validador propio)
    private Category category;

    /* Por si el día de mañana queremos guardar más fotos,
    usaremos una notación que coja un array de atributos */

    @NotNull
    //@Url Notacion con "startsWith("http")
    private String coverPhoto;

    //No obligatoria
    private String photo2;

    //No obligatoria
    private String photo3;

}
