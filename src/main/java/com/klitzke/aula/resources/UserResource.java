package com.klitzke.aula.resources;

import com.klitzke.aula.entities.User;
import com.klitzke.aula.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserServices services;

    //Aqui vamos criar um get para retornar todos os ‘users’ do meu banco de dados
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = services.findAll();
        return ResponseEntity.ok().body(list);
    }

    //Aqui vamos criar um get para buscar os ‘users’ pelo ‘ID’
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User obj = services.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    //Metodo POST para inserir ‘users’ no banco de dados
    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj) {
        obj = services.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    //Metodo DELETE para deletar um usuário por 'ID'
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        services.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj) {
        obj = services.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

}
