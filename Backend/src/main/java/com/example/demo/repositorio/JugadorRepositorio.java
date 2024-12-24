package com.example.demo.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Jugador;



@Repository
public interface JugadorRepositorio extends JpaRepository<Jugador, Integer> {

}
