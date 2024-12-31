package com.example.demo.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.modelo.Jugador;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Setter
@Getter
@Data
@ToString

public class ClubDTO {
    private String nombre;
    private String paisOrigen;
    private LocalDateTime fechaCreacionSistema;
    private EntrenadorDTO entrenador;
    private List<Jugador> jugadores;

}
