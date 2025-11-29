package com.pokemon.api_pokemon.exceptions;

public class PokemonNotFoundException extends RuntimeException {
    public PokemonNotFoundException(String message) {
        super(message);
    }

    public static PokemonNotFoundException byId(Long id){
        return new PokemonNotFoundException("Pokemon não encontrado para o id: " + id);
    }
}
