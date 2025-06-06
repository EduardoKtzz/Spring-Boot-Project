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

    //Buscar todos os ‘users’
    public List<User> findAll() {
        return repository.findAll();
    }

    //Buscar usuário por 'ID'
    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }

    //Inserir 'users'
    public User insert(User obj) {
        return repository.save(obj);
    }

    //Delete 'users'
    public void delete(Long id) {
        repository.deleteById(id);
    }

    //Atualizar 'users'
    public User update(Long id, User obj) {
        User entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
