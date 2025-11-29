package com.pokemon.api_pokemon.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_pokemon")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "pokemon")
    private String nome;

    @ManyToMany
    @JoinTable (
            name = "pokemon_tipo", // nome da tabela intermediária
            joinColumns = @JoinColumn(name = "pokemon_id"),
            inverseJoinColumns = @JoinColumn(name = "tipo_id")
    )
    private Set<Tipo> tipo = new HashSet<>();

    private Float altura;
    private Float peso;

}
