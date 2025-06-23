/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.info.email.repository;

import com.info.email.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author SEKAL
 */
public interface LoginRepository extends JpaRepository<Login, Integer>{
    
}
