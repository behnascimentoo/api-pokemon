package com.pokemon.api_pokemon.entities;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Represents a Pokémon entity")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "pokemon")
    private String name;

    @ManyToMany
    @JoinTable (
            name = "pokemon_tipo", // nome da tabela intermediária
            joinColumns = @JoinColumn(name = "pokemon_id"),
            inverseJoinColumns = @JoinColumn(name = "tipo_id")
    )
    private Set<TypePokemon> typePokemon = new HashSet<>();

    private Float hightPokemon;
    private Float wightPokemon;

    public Pokemon(Long id, String name, TypePokemon type) {
        this.id = id;
        this.name = name;
        if (type != null) {
            this.typePokemon.add(type);
        }
    }

}
