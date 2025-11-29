package com.pokemon.api_pokemon.service;

import com.pokemon.api_pokemon.dtos.CreatePokemonDto;
import com.pokemon.api_pokemon.dtos.PokemonResponseDto;
import com.pokemon.api_pokemon.dtos.UpdatePokemonDto;
import com.pokemon.api_pokemon.entities.Pokemon;
import com.pokemon.api_pokemon.entities.TypeName;
import com.pokemon.api_pokemon.entities.TypePokemon;
import com.pokemon.api_pokemon.exceptions.PokemonNotFoundException;
import com.pokemon.api_pokemon.exceptions.TypePokemonNotFoundException;
import com.pokemon.api_pokemon.mappers.PokemonMapper;
import com.pokemon.api_pokemon.repositories.PokemonRepository;
import com.pokemon.api_pokemon.repositories.TypePokemonRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PokemonServiceImp implements PokemonService{

    private final PokemonRepository pokemonRepository;
    private final TypePokemonRepository typePokemonRepository;
    private final PokemonMapper pokemonMapper;

    @Override
    public void addPokemon(@NotNull CreatePokemonDto dto) {
        Set<TypePokemon> typeEntities = typePokemonRepository
                .findByNameIn(dto.typePokemon());
        Pokemon pokemon = pokemonMapper.toEntity(dto, typeEntities);
        pokemonRepository.save(pokemon);
    }

    @Override
    public PokemonResponseDto updatePokemon(Long id, @NotNull UpdatePokemonDto dto) {
        Pokemon pokemon = pokemonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pokemon não encontrado"));
        Set<TypePokemon> typeEntities =
                typePokemonRepository.findByNameIn(dto.typePokemon());
        if (typeEntities.isEmpty()) {
            throw TypePokemonNotFoundException.byType(dto.typePokemon());
        }
        pokemonMapper.updateEntity(pokemon, dto, typeEntities);
        Pokemon updated = pokemonRepository.save(pokemon);
        return pokemonMapper.toDto(updated);
    }

    @Override
    public List<PokemonResponseDto> getAll() {
        return pokemonRepository.findAll()
                .stream()
                .map(pokemonMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PokemonResponseDto getPokemonByID(Long id) {
        return pokemonRepository.findById(id)
                .map(pokemonMapper::toDto)
                .orElseThrow(() -> PokemonNotFoundException.byId(id));
    }

    @Override
    public List<PokemonResponseDto> getPokemonByTypeName(String type) {
        TypeName typeName;
        try {
            typeName = TypeName.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new TypePokemonNotFoundException("Tipo inválido: " + type);
        }
        List<Pokemon> pokemons = pokemonRepository.findByTypePokemon_Name(typeName);
        if (pokemons.isEmpty()) {
            throw new TypePokemonNotFoundException("Nenhum Pokémon encontrado para o tipo: " + type);
        }
        return pokemons.stream()
                .map(pokemonMapper::toDto)
                .toList();
    }

    @Override
    public void deletePokemon(Long id) {
        pokemonRepository.findById(id)
                .orElseThrow(()-> PokemonNotFoundException.byId(id)) ;
        pokemonRepository.deleteById(id);
    }
}
