package com.klitzke.aula.resources;

import com.klitzke.aula.entities.Order;
import com.klitzke.aula.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderServices services;

    //Aqui vamos criar um get para retornar todos os ‘users’ do meu banco de dados
    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> list = services.findAll();
        return ResponseEntity.ok().body(list);
    }

    //Criando um GET para buscar pelo "ID"
    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        Order obj = services.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
