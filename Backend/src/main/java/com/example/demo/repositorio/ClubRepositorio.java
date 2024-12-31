package com.example.demo.repositorio;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.modelo.Club;



@Repository
public interface ClubRepositorio extends CrudRepository<Club, Integer> {

}
