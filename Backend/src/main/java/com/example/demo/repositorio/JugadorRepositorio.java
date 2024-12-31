package com.example.demo.repositorio;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Jugador;



@Repository
public interface JugadorRepositorio extends CrudRepository<Jugador, Integer> {

}
