package com.pokemon.api_pokemon.dtos;

import java.util.Set;

public record PokemonResponseDto(
        Long id,
        String name,
        Float wight,
        Float hight,
        Set<String> typePokemon
) {}
