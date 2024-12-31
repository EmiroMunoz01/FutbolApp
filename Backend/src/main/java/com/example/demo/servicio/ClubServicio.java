package com.example.demo.servicio;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ClubDTO;
import com.example.demo.exencion.RecursoNoEncontradoExencion;
import com.example.demo.modelo.Club;
import com.example.demo.repositorio.ClubRepositorio;

@Service
public class ClubServicio implements IClub {

    @Autowired
    ClubRepositorio clubRepositorio;

    @Override
    public List<Club> listarClubes() {
        return (List<Club>) this.clubRepositorio.findAll();
    }

    @Override
    public Club buscarClubId(Integer idClub) {
        Club club = this.clubRepositorio.findById(idClub)
                .orElseThrow(RecursoNoEncontradoExencion::new);
        return club;
    }

    @Override
    public Club guardarClub(ClubDTO clubDTO) {

        Club club = new Club();

        club.setNombre(clubDTO.getNombre());
        club.setPaisOrigen(clubDTO.getPaisOrigen());
        club.setJugadores(clubDTO.getJugadores());
        club.setFechaCreacionSistema(LocalDateTime.now());

       return this.clubRepositorio.save(club);
    }

    @Override
    public void eliminarClubPorId(Integer idClub) {
        this.clubRepositorio.deleteById(idClub);
    }

    @Override
    public Club actualizarClub(Integer id, ClubDTO clubDTO) {

        Club clubBaseDatos = this.clubRepositorio.findById(id).orElseThrow(RecursoNoEncontradoExencion::new);

        clubBaseDatos.setNombre(clubDTO.getNombre());
        clubBaseDatos.setPaisOrigen(clubDTO.getPaisOrigen());

        return this.clubRepositorio.save(clubBaseDatos);
    }

}
