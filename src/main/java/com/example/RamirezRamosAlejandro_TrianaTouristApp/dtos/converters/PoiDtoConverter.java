package com.example.RamirezRamosAlejandro_TrianaTouristApp.dtos.converters;

import com.example.RamirezRamosAlejandro_TrianaTouristApp.dtos.models.CreatePoiDto;
import com.example.RamirezRamosAlejandro_TrianaTouristApp.models.Poi;
import org.springframework.stereotype.Component;

@Component
public class PoiDtoConverter {

    public Poi createPoiDtoToPoi(CreatePoiDto c) {
        return new Poi(
                c.getName(),
                c.getDescription(),
                c.getLocation(),
                c.getDate(),
                c.getCategory(),
                c.getCoverPhoto(),
                c.getPhoto2(),
                c.getPhoto3()
        );
    }
}
