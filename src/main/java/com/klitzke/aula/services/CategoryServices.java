package com.klitzke.aula.services;

import com.klitzke.aula.entities.Category;
import com.klitzke.aula.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServices {

    //Atributos
    @Autowired
    private CategoryRepository repository;

    //Buscar todos as categorias
    public List<Category> findAll() {
        return repository.findAll();
    }

    //Buscar categorias por 'ID'
    public Category findById(Long id) {
        Optional<Category> obj = repository.findById(id);
        return obj.get();
    }
}
