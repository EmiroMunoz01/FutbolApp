package com.example.demo.servicio;

import java.util.List;

import com.example.demo.dto.ClubDTO;
import com.example.demo.modelo.Club;

public interface IClub {

    public List<Club> listarClubes();

    public Club buscarClubId(Integer idClub);

    public Club guardarClub(ClubDTO club);

    public void eliminarClubPorId(Integer idClub);

    public Club actualizarClub(Integer id, ClubDTO club);

}
