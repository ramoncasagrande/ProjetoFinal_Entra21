package com.entra21.projeto.repositories;

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

    String findByEmail(String email);
    
}
