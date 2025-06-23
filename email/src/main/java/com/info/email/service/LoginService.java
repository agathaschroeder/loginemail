/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.info.email.service;

import com.info.email.model.Login;
import com.info.email.repository.LoginRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author SEKAL
 */
@Service
public class LoginService { //centraliza a lógica de acesso ao banco de dados para a entidade
    @Autowired
    LoginRepository loginRepository;
    
    public Login localizar(int id) { //busca o id
        Optional<Login> loginBusca = loginRepository.findById(id);
        if (loginBusca.isPresent()) {
            return loginBusca.get(); //encontra
        } else {
            return null; //n encontra
        }
    }
    public List<Login> pesquisar(){ //todos os registros
        return loginRepository.findAll();
    }
    
    public Login salvar(Login login) {
        return loginRepository.save(login);
    }
    
    public void excluir(int id) {
        loginRepository.deleteById(id);
    }
}
