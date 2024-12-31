package com.example.demo.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "clubes")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Size(min = 3)
    @Column(name = "nombre", unique = true, columnDefinition = "VARCHAR(300)", nullable = false)
    private String nombre;

    @NotEmpty
    @Size(min = 3)
    @Column(name = "pais_origen", unique = true, columnDefinition = "VARCHAR(300)", nullable = false)
    private String paisOrigen;

    @Column(name = "fecha_creacion_sistema")
    private LocalDateTime fechaCreacionSistema;

    @OneToOne(targetEntity = Entrenador.class, cascade = CascadeType.PERSIST)
    private Entrenador entrenador;

    @OneToMany(targetEntity = Jugador.class, fetch = FetchType.LAZY, mappedBy = "club")
    private List<Jugador> jugadores = new ArrayList<>();

}
