package com.example.demo.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.modelo.Jugador;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class ClubDTO {

    private String nombre;
    private String paisOrigen;
    private LocalDateTime fechaCreacionSistema;
    private EntrenadorDTO entrenador;
    private List<Jugador> jugadores;

}
