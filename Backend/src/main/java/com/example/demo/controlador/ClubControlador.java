package com.example.demo.controlador;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Club;
import com.example.demo.servicio.ClubServicio;

@RestController
@RequestMapping("app-futbol")
public class ClubControlador {

    private final Logger LOGGER = LoggerFactory.getLogger(ClubControlador.class);

    @Autowired
    private ClubServicio clubServicio;

    @GetMapping("/club/{id}")
    public Club encontrarPorId(@PathVariable Integer id) {
        return clubServicio.buscarClubId(id);

    }

    @GetMapping("/club")
    public List<Club> listarClub() {
        return clubServicio.listarClub();
    }

    @DeleteMapping("/club/{id}")
    public void eliminarUsuario(@PathVariable Integer id) {

        Club club = clubServicio.buscarClubId(id);
        if (club != null) {
            LOGGER.info("Se elimino de forma exitosa el club {}", club.getNombre());
            clubServicio.eliminarClubPorId(id);
        } else {
            LOGGER.info("No se ha encontrado club con el id {}", id);
        }

    }

    // @PostMapping("/club")
    // public ResponseEntity<?> crearClub(
    //         @RequestBody Club ClubB) {

    //     // agregar validacion para verificar que el usuario no se repita

    //     try {
    //         Club club = new Club();
    //         club.setNombre(ClubB.getNombre());
    //         club.setEntrenador(ClubB.getEntrenador());
    //         LOGGER.info("Se ha creado exitosamente el usuario {}", ClubB);
    //         return ResponseEntity.ok(clubServicio.guardarClub(club));

    //     } catch (Exception e) {
    //         LOGGER.info("Error al intentar crear el usuario {}", ClubB);
    //         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al intentar crear un club.");
    //     }

    // }
}
