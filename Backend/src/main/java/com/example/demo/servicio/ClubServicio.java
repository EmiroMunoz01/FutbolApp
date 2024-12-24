package com.example.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Club;
import com.example.demo.repositorio.ClubRepositorio;

@Service
public class ClubServicio implements IClub {

    @Autowired
    ClubRepositorio clubRepositorio;

    @Override
    public List<Club> listarClub() {
        return this.clubRepositorio.findAll();
    }

    @Override
    public Club buscarClubId(Integer idClub) {
        Club club = this.clubRepositorio.findById(idClub).orElse(null);
        return club;
    }

    @Override
    public Club guardarClub(Club club) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'guardarClub'");
    }

    @Override
    public void eliminarClubPorId(Integer idclub) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarClubPorId'");
    }

    @Override
    public void actualizarClub(Club club) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarClub'");
    }

}
