package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
@Table(name = "jugadores")
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Size(min = 3)
    @Column(name = "nombre")
    private String nombre;

    @NotEmpty
    @Size(min = 3)
    @Column(name = "apellido")
    private String apellido;

    @NotEmpty
    @Min(2)
    @Max(3)
    @Column(name = "numero", unique = true)
    private Integer numero;

    @NotEmpty
    @Min(2)
    @Max(3)
    @Column(name = "posicion", unique = true)
    private String posicion;


    @ManyToOne(targetEntity = Club.class)
    private Club club;

}
