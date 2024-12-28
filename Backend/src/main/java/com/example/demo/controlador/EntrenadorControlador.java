package com.example.demo.controlador;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.EntrenadorDTO;
import com.example.demo.modelo.Entrenador;
import com.example.demo.servicio.EntrenadorServicio;

@RestController
@RequestMapping("app-futbol")
@CrossOrigin(value = "http://localhost:4200")
public class EntrenadorControlador {

    private final Logger LOGGER = LoggerFactory.getLogger(EntrenadorControlador.class);

    @Autowired
    private EntrenadorServicio entrenadorServicio;


    @GetMapping("/entrenador/{id}")
    public Entrenador encontrarPorId(@PathVariable Integer id) {
        return entrenadorServicio.buscarEntrenadorId(id);

    }

    

    @GetMapping("/entrenador")
    public List<Entrenador> listarEntrenador() {
        return entrenadorServicio.listarEntrenador();
    }

    @DeleteMapping("/entrenador/{id}")
    public void eliminarEntrenador(@PathVariable Integer id) {

        Entrenador entrenador = entrenadorServicio.buscarEntrenadorId(id);
        if (entrenador != null) {
            LOGGER.info("Se elimino de forma exitosa el entrenador {}", entrenador.getNombre());
            entrenadorServicio.eliminarEntrenadorPorId(id);
        } else {
            LOGGER.info("No se ha encontrado entrenador con el id {}", id);
        }

    }

    @PostMapping("/entrenador")
    public Entrenador crearEntrenador(
            @RequestBody EntrenadorDTO entrenadorDTO) {

        return entrenadorServicio.guardarEntrenador(entrenadorDTO);
    }

    @PutMapping("/entrenador/{id}")
    public Entrenador actualizarEntrenador(@PathVariable Integer id,
            @RequestBody EntrenadorDTO entrenadorDTO) {

        return entrenadorServicio.actualizarEntrenador(id, entrenadorDTO);

    }

}
