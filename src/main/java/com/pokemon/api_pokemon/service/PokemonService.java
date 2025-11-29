package com.pokemon.api_pokemon.service;

import com.pokemon.api_pokemon.dtos.CreatePokemonDto;
import com.pokemon.api_pokemon.dtos.PokemonResponseDto;
import com.pokemon.api_pokemon.dtos.UpdatePokemonDto;

import java.util.List;

public interface PokemonService {
    void addPokemon(CreatePokemonDto createPokemonDto);
    PokemonResponseDto updatePokemon(Long id, UpdatePokemonDto dto);
    List<PokemonResponseDto> getAll();
    PokemonResponseDto getPokemonByID(Long id);
    List<PokemonResponseDto> getPokemonByTypeName(String type);
    void deletePokemon(Long id);
}
