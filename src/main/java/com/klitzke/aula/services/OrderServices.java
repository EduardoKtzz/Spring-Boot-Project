package com.klitzke.aula.services;

import com.klitzke.aula.entities.Order;
import com.klitzke.aula.repositories.OrderRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServices {

    @Autowired
    private OrderRepositoty orderRepositoty;

    //Buscar todos os pedidos
    public List<Order> findAll() {
        return orderRepositoty.findAll();
    }

    //Buscar usuário por 'ID'
    public Order findById(Long id) {
        Optional<Order> obj = orderRepositoty.findById(id);
        return obj.get();
    }

}
