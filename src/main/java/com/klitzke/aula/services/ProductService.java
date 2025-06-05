package com.klitzke.aula.services;

import com.klitzke.aula.entities.Product;
import com.klitzke.aula.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    //Atributos
    @Autowired
    private ProductRepository repository;

    //Buscar todos os pedidos
    public List<Product> findAll() {
        return repository.findAll();
    }

    //Buscar usuário por 'ID'
    public Product findById(Long id) {
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }
}
