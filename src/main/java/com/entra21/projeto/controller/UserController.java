package com.entra21.projeto.controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entra21.projeto.model.AuthModel;
import com.entra21.projeto.model.Users;
import com.entra21.projeto.repositories.UserRepository;

/**
 * Classe UserController
 * Criada em 05/09/2022
 * 
 * @author Ramon Casagrande
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * Método para listar usuários
     * Criada em 05/09/2022
     * 
     * @author Ramon Casagrande
     */

    @GetMapping
    public List<Users> list() {
        return userRepository.findAll();
    }

    /**
     * Método para criar novo usuário
     * Criada em 15/10/2022
     * 
     * @author Ramon Casagrande
     */

    @PostMapping
    public Boolean add(@RequestBody Users usuario)
    throws NoSuchAlgorithmException, UnsupportedEncodingException
        {
        Users novoUsuario = new Users();
        novoUsuario.setName(usuario.getName());
        novoUsuario.setEmail(usuario.getEmail());
        novoUsuario.setPassword(encryptPassword(usuario.getPassword()));
        novoUsuario.setRole("ALUNO");
        userRepository.save(novoUsuario);

        return true;
    }

    /**
     * Método para buscar usuários pelo Email
     * Criada em 05/09/2022
     * 
     * @author Ramon Casagrande
     */

    @GetMapping("/{email}")
    public ResponseEntity<Optional<Users>> setUser(@PathVariable String email) {
        Optional<Users> user = userRepository.findByEmail(email);
        return ResponseEntity.ok(user);
    }

    /**
     * Método para buscar usuários pelo ID
     * Criada em 05/09/2022
     * 
     * @author Ramon Casagrande
     */

    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<Users>> setUserId(@PathVariable Long id) {
        Optional<Users> user = userRepository.findById(id);
        return ResponseEntity.ok(user);
    }

    /**
     * Método para Autenticação
     * Criada em 17/10/2022
     * 
     * @author Ramon Casagrande
     */

    @PostMapping("/auth")
    public Boolean doAuth(@RequestBody AuthModel auth) 
    throws NoSuchAlgorithmException, UnsupportedEncodingException
    {
       Users user = userRepository.findByEmailAndPassword(auth.getEmail(), this.encryptPassword(auth.getPassword()));
       return user == null ? false : true;
    }

    private String encryptPassword(String password)
    throws NoSuchAlgorithmException, UnsupportedEncodingException
    {
        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte messageDigest [] = algorithm.digest(password.getBytes("UTF-8"));

        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest){
            hexString.append(String.format("%02X", 0xFF & b));
        }
        String encryptedPassword = hexString.toString().toLowerCase();
        return encryptedPassword;
    }


}
