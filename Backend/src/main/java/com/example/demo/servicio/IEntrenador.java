package com.example.demo.servicio;

import java.util.List;

import com.example.demo.modelo.Entrenador;

public interface IEntrenador {

    public List<Entrenador> listarEntrenador();

    public Entrenador buscarEntrenadorId(Integer idEntrenador);

    public Entrenador guardarEntrenador(Entrenador entrenador);

    public void eliminarEntrenadorPorId(Integer idEntrenador);

    public void actualizarEntrenador(Entrenador entrenador);

}
