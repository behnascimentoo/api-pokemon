package com.pokemon.api_pokemon.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_tipo")
public class Tipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private NomeTipo nome;

    @ManyToMany(mappedBy = "tipo")
    private Set<Pokemon> pokemons = new HashSet<>();
}
