package com.pokemon.api_pokemon.dtos;

import com.pokemon.api_pokemon.entities.TypeName;

import java.util.Set;

public record UpdatePokemonDto(
        String name,
        Float hight,
        Float wight,
        Set<TypeName> typePokemon
) {}
