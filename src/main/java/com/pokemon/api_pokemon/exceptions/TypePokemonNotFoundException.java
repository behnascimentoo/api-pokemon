package com.pokemon.api_pokemon.exceptions;

import com.pokemon.api_pokemon.entities.TypePokemon;

public class TypePokemonNotFoundException extends RuntimeException {
    public TypePokemonNotFoundException(String message) {
        super(message);
    }

    public static TypePokemonNotFoundException byType(TypePokemon typePokemon){
        return new TypePokemonNotFoundException("Pokemon não encontrado para os tipos: " + typePokemon);
    }
}
