package com.pokemon.api_pokemon.repositories;

import com.pokemon.api_pokemon.entities.TypeName;
import com.pokemon.api_pokemon.entities.TypePokemon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface TypePokemonRepository extends JpaRepository<TypePokemon, Long> {
    Set<TypePokemon> findByNameIn(Set<TypeName> names);
}
