package com.example.RamirezRamosAlejandro_TrianaTouristApp.services;

import com.example.RamirezRamosAlejandro_TrianaTouristApp.errors.exceptions.EntityNotFoundException;
import com.example.RamirezRamosAlejandro_TrianaTouristApp.models.Category;
import com.example.RamirezRamosAlejandro_TrianaTouristApp.repos.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repositorio;

    public List<Category> findAll(){
        return repositorio.findAll();
    }

    public Category findById(Long id){
        Category actual = repositorio.findById(id).orElse(null);
        if (actual==null){
            throw new EntityNotFoundException(id.toString(), Category.class);
        }
        return actual;
    }

    //MIRA ESTO
    public Category save(Category newCategory) {
        Category categoriaAnterior = repositorio.getById(newCategory.getId());
        return newCategory;
    }

    public Category edit(Category editedCategory) {
        repositorio.save(editedCategory);
    }



}
