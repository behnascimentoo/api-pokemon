package com.pokemon.api_pokemon.mappers;

import com.pokemon.api_pokemon.dtos.CreatePokemonDto;
import com.pokemon.api_pokemon.dtos.PokemonResponseDto;
import com.pokemon.api_pokemon.dtos.UpdatePokemonDto;
import com.pokemon.api_pokemon.entities.Pokemon;
import com.pokemon.api_pokemon.entities.TypeName;
import com.pokemon.api_pokemon.entities.TypePokemon;
import com.pokemon.api_pokemon.repositories.PokemonRepository;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PokemonMapper {

    public Pokemon toEntity(CreatePokemonDto dto, Set<TypePokemon> typeEntities){
        Pokemon pokemon = new Pokemon();
        pokemon.setName(dto.name());
        pokemon.setHightPokemon(dto.hight());
        pokemon.setWightPokemon(dto.wight());
        pokemon.setTypePokemon(typeEntities);
        return pokemon;
    }

    public PokemonResponseDto toDto(Pokemon pokemon){
        Set<String> typesPokemons = pokemon.getTypePokemon()
                .stream()
                .map(tp -> tp.getName().name())
                .collect(Collectors.toSet());

        return new PokemonResponseDto(
                pokemon.getId(),
                pokemon.getName(),
                pokemon.getWightPokemon(),
                pokemon.getHightPokemon(),
                typesPokemons
        );
    }

    public void updateEntity(Pokemon pokemon, UpdatePokemonDto dto ,Set<TypePokemon> typeEntities){
        pokemon.setName(dto.name());
        pokemon.setWightPokemon(dto.wight());
        pokemon.setHightPokemon(dto.hight());
        pokemon.setTypePokemon(typeEntities);
    }
}
