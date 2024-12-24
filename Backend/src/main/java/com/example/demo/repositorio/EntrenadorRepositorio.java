package com.example.demo.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Entrenador;



@Repository
public interface EntrenadorRepositorio extends JpaRepository<Entrenador, Integer> {

}
