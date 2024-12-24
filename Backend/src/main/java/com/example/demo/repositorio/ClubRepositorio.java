package com.example.demo.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Club;



@Repository
public interface ClubRepositorio extends JpaRepository<Club, Integer> {

}
