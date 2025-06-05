package com.klitzke.aula.resources;

import com.klitzke.aula.entities.Category;
import com.klitzke.aula.entities.User;
import com.klitzke.aula.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    //Atributos
    @Autowired
    private CategoryServices services;

    //Aqui vamos criar um get para retornar todos os ‘users’ do meu banco de dados
    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> list = services.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Category obj = services.findById(id);
        return ResponseEntity.ok().body(obj);
    }


}
