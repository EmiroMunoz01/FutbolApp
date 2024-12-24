package com.example.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Entrenador;
import com.example.demo.repositorio.EntrenadorRepositorio;

@Service
public class EntrenadorServicio implements IEntrenador {

    @Autowired
    private EntrenadorRepositorio entrenadorRepositorio;

    @Override
    public List<Entrenador> listarEntrenador() {
        return this.entrenadorRepositorio.findAll();
    }

    @Override
    public Entrenador buscarEntrenadorId(Integer idEntrenador) {
        Entrenador entrenador = this.entrenadorRepositorio.findById(idEntrenador).orElse(null);
        return entrenador;
    }

    @Override
    public Entrenador guardarEntrenador(Entrenador entrenador) {
        return this.entrenadorRepositorio.save(entrenador);
    }

    @Override
    public void eliminarEntrenadorPorId(Integer idEntrenador) {
        this.entrenadorRepositorio.deleteById(idEntrenador);
    }

    @Override
    public void actualizarEntrenador(Entrenador entrenador) {
        this.entrenadorRepositorio.save(entrenador);
    }

}
