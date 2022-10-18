package com.entra21.projeto.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entra21.projeto.model.Users;

/**
 * Repositório de Usuários
 * Criado em 11/08/2022
 * Atualizado em 05/09/2022
 * 
 * @author Ramon Casagrande
 */

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    //Optional<Users> findByEmail(String email);

    public Users  findByEmail(String email);

    /**
    * Método de busca por email e senha
    * Criado em 17/10/2022
    * 
    * @author Ramon Casagrande
    */

    public Users findByEmailAndPassword(String email, String password);

    
}
