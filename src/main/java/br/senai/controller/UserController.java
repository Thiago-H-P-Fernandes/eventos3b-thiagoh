package br.senai.controller;

import br.senai.model.Usuario;
import br.senai.service.userservice.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/createUser")
    public ResponseEntity<Boolean> createUsuario(@RequestBody Usuario usuario){
        try {
            String userPass = usuario.getPassword();
            String userEncodedPass = passwordEncoder.encode(userPass);
            usuario.setPassword(userEncodedPass);
            return ResponseEntity.ok(userService.createUsuario(usuario));
        }catch (Exception e){
            throw new IllegalArgumentException("Ocorreu um erro");
        }
    }
}