package com.example.RamirezRamosAlejandro_TrianaTouristApp.services;

import com.example.RamirezRamosAlejandro_TrianaTouristApp.models.Poi;
import com.example.RamirezRamosAlejandro_TrianaTouristApp.repos.PoiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PoiService {

    private final PoiRepository repositorio;

    public List<Poi> findAll(){
        return repositorio.findAll();
    }

    public Poi findById(Long id){
        return repositorio.findById(id).orElse(null);
    }

    public Poi edit(Poi editedPoi) {
        Poi antiguoPoi= repositorio.findById(editedPoi.getId()).orElse(null);
        antiguoPoi.setName(editedPoi.getName());
        antiguoPoi.setLocation(editedPoi.getLocation());
        antiguoPoi.setDescription(editedPoi.getDescription());
        antiguoPoi.setDate(editedPoi.getDate());

        antiguoPoi.setCategory(editedPoi.getCategory());

        antiguoPoi.setCoverPhoto(antiguoPoi.getCoverPhoto());
        antiguoPoi.setPhoto2(antiguoPoi.getPhoto2());
        antiguoPoi.setPhoto3(antiguoPoi.getPhoto3());

        return editedPoi;
    }

    public Poi save(Poi newPoi) {
        repositorio.save(newPoi);
        return newPoi;
    }

    public void delete(Long id) {
        repositorio.deleteById(id);
    }

}
