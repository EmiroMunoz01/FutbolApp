package com.example.demo.servicio;

import java.util.List;

import com.example.demo.modelo.Club;

public interface IClub {

    public List<Club> listarClub();

    public Club buscarClubId(Integer idclub);

    public Club guardarClub(Club club);

    public void eliminarClubPorId(Integer idclub);

    public void actualizarClub(Club club);

}
