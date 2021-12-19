package com.example.RamirezRamosAlejandro_TrianaTouristApp.services;

import com.example.RamirezRamosAlejandro_TrianaTouristApp.models.Category;
import com.example.RamirezRamosAlejandro_TrianaTouristApp.models.Poi;
import com.example.RamirezRamosAlejandro_TrianaTouristApp.repos.CategoryRepository;
import com.example.RamirezRamosAlejandro_TrianaTouristApp.services.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService extends BaseService<Category, Long, CategoryRepository> {

    private final CategoryRepository repositorio;

}
