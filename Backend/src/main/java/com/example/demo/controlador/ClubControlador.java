package com.example.demo.controlador;

import java.time.LocalDateTime;
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

import com.example.demo.modelo.Club;
import com.example.demo.modelo.Entrenador;
import com.example.demo.servicio.ClubServicio;
import com.example.demo.servicio.EntrenadorServicio;

@RestController
@RequestMapping("app-futbol")
@CrossOrigin(value = "http://localhost:4200")
public class ClubControlador {

    private final Logger LOGGER = LoggerFactory.getLogger(ClubControlador.class);

    @Autowired
    private ClubServicio clubServicio;

    @Autowired
    private EntrenadorServicio entrenadorServicio;

    @GetMapping("/club/{id}")
    public Club encontrarPorId(@PathVariable Integer id) {
        return clubServicio.buscarClubId(id);

    }

    @GetMapping("/club")
    public List<Club> listarClub() {
        return clubServicio.listarClubes();
    }

    @DeleteMapping("/club/{id}")
    public void eliminarClub(@PathVariable Integer id) {

        Club club = clubServicio.buscarClubId(id);
        if (club != null) {
            LOGGER.info("Se elimino de forma exitosa el club {}", club.getNombre());
            clubServicio.eliminarClubPorId(id);
        } else {
            LOGGER.info("No se ha encontrado club con el id {}", id);
        }
    }

    @PostMapping("/club")
    public Club crearClub(@RequestBody Club club) {

        Entrenador x = entrenadorServicio.buscarEntrenadorId(club.getEntrenador().getId());
        if (x != null) {
            club.setEntrenador(x);
            return clubServicio.guardarClub(club);

        } else {
            club.getEntrenador().setFechaCreacion(LocalDateTime.now());
            return clubServicio.guardarClub(club);
        }
        
    }

    @PutMapping("/club/{id}")
    public Club actualizarClub(@PathVariable Integer id,
            @RequestBody Club club) {

        return clubServicio.actualizarClub(id, club);

    }

}
