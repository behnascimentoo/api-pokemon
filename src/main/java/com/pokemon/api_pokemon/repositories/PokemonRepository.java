package com.pokemon.api_pokemon.repositories;

import com.pokemon.api_pokemon.dtos.PokemonResponseDto;
import com.pokemon.api_pokemon.entities.Pokemon;
import com.pokemon.api_pokemon.entities.TypeName;
import com.pokemon.api_pokemon.entities.TypePokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    Optional<List<Pokemon>> findByTypePokemon(TypePokemon typePokemon);
    List<Pokemon> findByTypePokemon_Name(TypeName name);
}
