package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.modelo.Entrenador;

@Repository
public interface EntrenadorRepositorio extends CrudRepository<Entrenador, Integer> {

    @Query(value = "SELECT * FROM entrenadores e WHERE e.cedula_entrenador = :cedula_entrenador", nativeQuery = true)
    Entrenador encontrarEntrenadorPorCedula(@Param("cedula_entrenador") Integer cedula_entrenador);

}
