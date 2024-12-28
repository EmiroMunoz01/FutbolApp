package com.example.demo.repositorio;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Entrenador;



@Repository
public interface EntrenadorRepositorio extends CrudRepository<Entrenador, Integer> {

}
