package com.klitzke.aula.resources;

import com.klitzke.aula.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    //Aqui vamos criar um get para retornar todos os users do meu banco de dados
    @GetMapping
    public ResponseEntity<User> findAll() {
        User u = new User(1, "Eduardo Klitzke", "Edu@gmail.com", "99999999999", "12234");
        return ResponseEntity.ok().body(u);
    }
}
