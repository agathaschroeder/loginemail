/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.info.usuariologin.service;

import com.info.usuariologin.model.Login;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

/**
 *
 * @author SEKAL
 */
@Service
public class LoginService {
    private final WebClient webClient;
    
    public LoginService() {
        this.webClient = WebClient.builder().baseUrl("\"http://localhost:8080/login").build();
    }
    
    public Login salva(Login login) {
        return webClient
                .post()
                .contentType(MediaType.APPLICATION_JSON)
                .headers(headers -> headers.setBasicAuth("admin", "1234"))
                .bodyValue(login)
                .retrieve()
                .bodyToMono(Login.class).block()
                ;
    }
    
    public Login localiza(int id) {
        return webClient.get()
                .uri("/{id}", id)
                .headers(headers -> headers.setBasicAuth("admin", "1234"))
                .retrieve()
                .bodyToMono(Login.class).block();
    }
    
    public List<Login> pesquisa() {
        return webClient.get()
                .headers(headers -> headers.setBasicAuth("admin", "1234"))
                .retrieve()
                .bodyToFlux(Login.class)
                .collectList().block();
    }
    public void exclui(int id) {
        webClient.delete()
                .uri("/{id}", id)
                .headers(headers -> headers.setBasicAuth("admin", "1234"))
                .retrieve()
                .bodyToMono(Void.class).block();
    }
    
}
