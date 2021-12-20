package com.example.RamirezRamosAlejandro_TrianaTouristApp.dtos.converters;

import com.example.RamirezRamosAlejandro_TrianaTouristApp.dtos.models.CreateCategoryDto;
import com.example.RamirezRamosAlejandro_TrianaTouristApp.models.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryDtoConverter {

    public Category createCategoryDtoToCategory(CreateCategoryDto c) {
        return new Category(
                c.getName()
        );
    }
}
