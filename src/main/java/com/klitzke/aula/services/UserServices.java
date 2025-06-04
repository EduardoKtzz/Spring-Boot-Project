package com.klitzke.aula.services;

import com.klitzke.aula.entities.User;
import com.klitzke.aula.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private UserRepository repository;

    //Buscar todos os users
    public List<User> findAll() {
        return repository.findAll();
    }

    //Buscar usuário por 'ID'
    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }

}
