package com.example.demo.controlador;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
            @RequestBody Entrenador entrenador) {

        return this.entrenadorServicio.guardarEntrenador(entrenador);

    }

    @PutMapping("/entrenador/{id}")
    public ResponseEntity<?> actualizarEntrenador(@PathVariable Integer id,
            @RequestBody Entrenador entrenadorActualizado) {

        try {
            Entrenador entrenadorExistentente = entrenadorServicio.buscarEntrenadorId(id);

            if (entrenadorExistentente != null) {
                entrenadorExistentente.setNombre(entrenadorActualizado.getNombre());
                entrenadorExistentente.setApellido(entrenadorActualizado.getApellido());
                entrenadorExistentente.setEdad_entrenador(entrenadorActualizado.getEdad_entrenador());
                entrenadorExistentente.setCedula_entrenador(entrenadorActualizado.getCedula_entrenador());
                entrenadorExistentente.setNacionalidad(entrenadorActualizado.getNacionalidad());
                entrenadorServicio.guardarEntrenador(entrenadorExistentente);
                return ResponseEntity.ok(entrenadorExistentente);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entrenador no encontrado.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al actualizar el entrenador.");
        }
    }

}
