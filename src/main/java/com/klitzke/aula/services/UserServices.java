package com.klitzke.aula.services;

import com.klitzke.aula.entities.User;
import com.klitzke.aula.repositories.UserRepository;
import com.klitzke.aula.services.exceptions.DatabaseException;
import com.klitzke.aula.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    //Inserir 'users'
    public User insert(User obj) {
        return repository.save(obj);
    }

    //Delete 'users'
    public void delete(Long id) {
        try {
            if(!repository.existsById(id)) throw new ResourceNotFoundException(id);
            repository.deleteById(id);
        }catch (ResourceNotFoundException e){
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e1) {
            throw new DatabaseException(e1.getMessage());
        }
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
