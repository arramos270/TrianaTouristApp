package com.example.RamirezRamosAlejandro_TrianaTouristApp.services.base;

import com.example.RamirezRamosAlejandro_TrianaTouristApp.errors.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class BaseService<T, ID, R extends JpaRepository<T, ID>> {

    @Autowired
    protected R repositorio;

    public List<T> findAll() {
        return repositorio.findAll();
    }

    public Optional<T> findById(ID id) {
        Optional<T> result = repositorio.findById(id);

        if (result==null) {
            throw new EntityNotFoundException(id.toString(), result.getClass());
        } else {
            return result;
        }
    }

    public T save(T t) {
        return repositorio.save(t);
    }

    public T edit(T t) {
        return save(t);
    }

    public void delete(T t) {
        repositorio.delete(t);
    }

    public void deleteById(ID id) {
        repositorio.deleteById(id);
    }
}
