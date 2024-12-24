package com.example.demo.servicio;

import java.util.List;

import com.example.demo.modelo.Entrenador;
import com.example.demo.modelo.Jugador;

public interface IJugador {

    public List<Jugador> listarJugador();

    public Jugador buscarJugadorId(Integer idJugador);

    public Jugador guardarJugador(Entrenador entrenador);

    public void eliminarJugadorPorId(Integer idJugador);

    public void actualizarJugador(Jugador jugador);

}
