package com.entra21.projeto.model;

/**
 * Classe Modelo de Autenticação
 * Criada em 17/10/2022
 * 
 * @author: Ramon Casagrande
 */

public class AuthModel {

    private String email;
    private String password;


    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
