package com.pokemon.api_pokemon.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "tb_tipo")
public class TypePokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private TypeName name;

    @ManyToMany(mappedBy = "typePokemon")
    private Set<Pokemon> pokemons = new HashSet<>();

    public TypePokemon(Long id, TypeName name) {
        this.id = id;
        this.name = name;
    }
}
