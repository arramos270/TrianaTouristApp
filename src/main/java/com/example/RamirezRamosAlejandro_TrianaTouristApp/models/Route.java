package com.example.RamirezRamosAlejandro_TrianaTouristApp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Route {

    @Id
    @GeneratedValue
    private Long id;

    //Debe ser único (Podemos usar el validador propio que hicimos para Category
    private String name;

    //Aqui vinculamos unidireccionalmente con Poi
    @OneToMany
    @JoinColumn(name = "route_id")
    private List<Poi> steps;

    public Route(String name, List<Poi> steps) {
        this.name = name;
        this.steps = steps;
    }
}
