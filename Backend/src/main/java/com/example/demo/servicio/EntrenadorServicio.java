package com.example.demo.servicio;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exencion.RecursoNoEncontradoExencion;
import com.example.demo.modelo.Entrenador;
import com.example.demo.repositorio.EntrenadorRepositorio;

@Service
public class EntrenadorServicio implements IEntrenador {

    @Autowired
    private EntrenadorRepositorio entrenadorRepositorio;

    @Override
    public List<Entrenador> listarEntrenador() {
        return (List<Entrenador>) this.entrenadorRepositorio.findAll();
    }

    @Override
    public Entrenador buscarEntrenadorId(Integer idEntrenador) {
        Entrenador entrenador = this.entrenadorRepositorio.findById(idEntrenador)
                .orElseThrow(RecursoNoEncontradoExencion::new);
        return entrenador;
    }

    @Override
    public Entrenador guardarEntrenador(Entrenador entrenador) {
               
        entrenador.setFechaCreacion(LocalDateTime.now());
        return this.entrenadorRepositorio.save(entrenador);
    }

    @Override
    public void eliminarEntrenadorPorId(Integer idEntrenador) {
        this.entrenadorRepositorio.deleteById(idEntrenador);
    }

    @Override
    public Entrenador actualizarEntrenador(Integer id, Entrenador entrenador) {

        Entrenador entrenadorBaseDatos = this.entrenadorRepositorio.findById(id).orElseThrow(RecursoNoEncontradoExencion::new);
        
        entrenadorBaseDatos.setNombre(entrenador.getNombre());
        entrenadorBaseDatos.setApellido(entrenador.getApellido());
        entrenadorBaseDatos.setEdad_entrenador(entrenador.getEdad_entrenador());
        entrenadorBaseDatos.setCedula_entrenador(entrenador.getCedula_entrenador());
        entrenadorBaseDatos.setNacionalidad(entrenador.getNacionalidad());
        return this.entrenadorRepositorio.save(entrenadorBaseDatos);
    }

    @Override
    public void eliminarTodosEntrenadores() {
        this.entrenadorRepositorio.deleteAll();

    }

}
