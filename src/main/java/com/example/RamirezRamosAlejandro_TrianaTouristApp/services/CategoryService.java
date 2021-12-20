package com.example.RamirezRamosAlejandro_TrianaTouristApp.services;

import com.example.RamirezRamosAlejandro_TrianaTouristApp.errors.exceptions.EntityNotFoundException;
import com.example.RamirezRamosAlejandro_TrianaTouristApp.errors.exceptions.UniqueCategoryNameException;
import com.example.RamirezRamosAlejandro_TrianaTouristApp.models.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryService servicio;

    public List<Category> findAll(){
        return servicio.findAll();
    }

    public Category findById(Long id){
        Category actual = servicio.findById(id);
        if (actual==null){
            throw new EntityNotFoundException(id.toString(), Category.class);
        }
        return actual;
    }

    public Category edit(Category editedCategory) {
        this.comprobadorDeNombreUnico(editedCategory);
        Category antiguaCategoria= this.findById(editedCategory.getId());
        antiguaCategoria.setName(editedCategory.getName());
        return editedCategory;
    }

    public Category save(Category newCategory) {
        this.comprobadorDeNombreUnico(newCategory);
        servicio.save(newCategory);
        return newCategory;
    }

    public void delete(Long id) {
        servicio.delete(id);
    }

    public void comprobadorDeNombreUnico(Category c){
        servicio.findAll().forEach((cat) -> {
            if(cat.getName()==c.getName()){
                throw new UniqueCategoryNameException(c.getName());
            }
        });
    }

}
