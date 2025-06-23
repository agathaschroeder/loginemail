/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.info.email.controller;

import com.info.email.model.Login;
import com.info.email.service.LoginService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author SEKAL
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginService loginService;
    
    @GetMapping("/{id}")
    public ResponseEntity<Login> localizar(@PathVariable int id) {
        return ResponseEntity.ok(loginService.localizar(id));
    }
    
    @GetMapping()
    public ResponseEntity<List<Login>> pesquisar() {
        return ResponseEntity.ok(loginService.pesquisar());
    }
    
    @PostMapping()
    public ResponseEntity<Login> salvar(@RequestBody Login login) {
        return ResponseEntity.ok(loginService.salvar(login));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable int id) {
        try {
            loginService.excluir(id);
            return ResponseEntity.ok("Login " + id + " excluído!");
        } catch (Exception e) {
        return ResponseEntity.ok("Erro ao excluir o Login " + id + ": " + e.getMessage());
    }
    }
}
