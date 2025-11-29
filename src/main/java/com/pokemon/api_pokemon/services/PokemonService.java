package com.pokemon.api_pokemon.services;

import com.pokemon.api_pokemon.dtos.CreatePokemonDto;
import com.pokemon.api_pokemon.dtos.PokemonResponseDto;
import com.pokemon.api_pokemon.dtos.UpdatePokemonDto;
import com.pokemon.api_pokemon.entities.Pokemon;
import com.pokemon.api_pokemon.entities.TypePokemon;

import java.util.List;

public interface PokemonService {
    void addPokemon(CreatePokemonDto createPokemonDto);
    PokemonResponseDto updatePokemon(Long id, UpdatePokemonDto dto);
    List<PokemonResponseDto> getAll();
    PokemonResponseDto getPokemonByID(Long id);
    List<PokemonResponseDto> getPokemonByType(TypePokemon typePokemon);
    void deletePokemon(Long id);
}
