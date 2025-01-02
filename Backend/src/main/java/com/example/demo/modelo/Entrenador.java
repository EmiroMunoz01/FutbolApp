package com.example.demo.modelo;

import java.time.LocalDateTime;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
@Table(name = "entrenadores")

public class Entrenador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 3, message = "whatever")
    @Column(name = "nombre")
    private String nombre;

    @Size(min = 3, message = "whatever")
    @Column(name = "apellido")
    private String apellido;

    @Min(1)
    @Max(100)
    @Column(name = "edad_entrenador")
    private Integer edad_entrenador;

    @Min(100000)

    @Column(name = "cedula_entrenador", unique = true)
    private Integer cedula_entrenador;

    @Size(min = 3, message = "whatever")
    @Column(name = "nacionalidad")
    private String nacionalidad;



    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

}
