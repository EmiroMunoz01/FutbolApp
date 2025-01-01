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
    public Club guardarClub(Club club) {

        // Club clubBD = new Club();

        // clubBD.setNombre(club.getNombre());
        // clubBD.setPaisOrigen(club.getPaisOrigen());
        // clubBD.setJugadores(club.getJugadores());
        // clubBD.setEntrenador(club.getEntrenador());
        club.setFechaCreacionSistema(LocalDateTime.now());

       return this.clubRepositorio.save(club);
    }

    @Override
    public void eliminarClubPorId(Integer idClub) {
        this.clubRepositorio.deleteById(idClub);
    }

    @Override
    public Club actualizarClub(Integer id, Club club) {

        Club clubBaseDatos = this.clubRepositorio.findById(id).orElseThrow(RecursoNoEncontradoExencion::new);

        clubBaseDatos.setNombre(club.getNombre());
        clubBaseDatos.setPaisOrigen(club.getPaisOrigen());

        return this.clubRepositorio.save(clubBaseDatos);
    }

}
