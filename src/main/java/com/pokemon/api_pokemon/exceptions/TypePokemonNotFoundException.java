package com.pokemon.api_pokemon.exceptions;

import com.pokemon.api_pokemon.entities.TypeName;
import java.util.Set;

public class TypePokemonNotFoundException extends RuntimeException {
    public TypePokemonNotFoundException(String message) {
        super(message);
    }

    public static TypePokemonNotFoundException byType(Set<TypeName> types){
        return new TypePokemonNotFoundException("Pokemon não encontrado para os tipos: " + types);
    }
}
